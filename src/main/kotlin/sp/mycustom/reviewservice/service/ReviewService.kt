package sp.mycustom.reviewservice.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.ReviewDTO
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.exception.DataFetchException
import sp.mycustom.reviewservice.exception.DataInsertionException
import sp.mycustom.reviewservice.repository.ReviewRepository
import sp.mycustom.reviewservice.validation.withReviewValidation
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
            val movie = movieService.getMovieById(movieId)
            log.info { "Adding Review for movie" }
            withReviewValidation(movie.block()) {
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
