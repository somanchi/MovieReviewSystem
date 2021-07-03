package sp.sample.movieReview.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.sample.movieReview.dto.ReviewDTO
import sp.sample.movieReview.entities.Review
import sp.sample.movieReview.exception.DataFetchException
import sp.sample.movieReview.exception.DataInsertionException
import sp.sample.movieReview.exception.MovieNotFoundException
import sp.sample.movieReview.repository.ReviewRepository
import sp.sample.movieReview.validation.withReviewValidation
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.UUID

@Service
class ReviewService {

    private val log: KLogger = KotlinLogging.logger {}

    @Autowired
    lateinit var reviewRepository: ReviewRepository

    @Autowired
    lateinit var movieService: MovieService

    fun addReview(reviewDTO: ReviewDTO): Mono<Review> {
        try {
            val movieId = UUID.nameUUIDFromBytes(reviewDTO.movieName.toLowerCase().toByteArray()).toString()
            val movie = movieService.getMovieById(movieId).block()
                ?: throw MovieNotFoundException(errorMessage = "Movie ${reviewDTO.movieName} is not found")
            log.info { "Adding Review for movie" }
            withReviewValidation(movie) {
                val review = Review(
                    review = reviewDTO.review,
                    postedDate = OffsetDateTime.now()
                        .withNano(0).withOffsetSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    lastUpdatedAt = OffsetDateTime.now()
                        .withNano(0).withOffsetSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    movieName = reviewDTO.movieName,
                    ratting = reviewDTO.ratting,
                    movieId = UUID.nameUUIDFromBytes(
                        reviewDTO.movieName.toLowerCase().toByteArray()
                    ).toString()
                )
                return reviewRepository.save(review)
            }
        } catch (e: Exception) {
            throw DataInsertionException(errorMessage = "Failed to insert review $reviewDTO")
        }
    }

    fun getReviews(movieName: String): Flux<Review> {
        try {
            return reviewRepository.findByMovieName(movieName)
        } catch (e: Exception) {
            throw DataFetchException(errorMessage = "Failed to fetch reviews")
        }
    }
}
