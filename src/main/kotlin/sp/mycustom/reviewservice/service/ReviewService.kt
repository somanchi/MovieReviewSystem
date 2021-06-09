package sp.mycustom.reviewservice.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.ReviewDTO
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.repository.ReviewRepository
import sp.mycustom.reviewservice.utils.DATE_FORMAT
import sp.mycustom.reviewservice.validation.withReviewValidation
import java.time.OffsetDateTime

@Service
class ReviewService {

    private val log: KLogger = KotlinLogging.logger {}

    @Autowired
    lateinit var reviewRepository: ReviewRepository

    @Autowired
    lateinit var movieService: MovieService

    fun addReview(reviewDTO: ReviewDTO): Mono<Review> {
        withReviewValidation(movieService.getMovieByName(reviewDTO.movieName)) {
            log.info { "Adding Review for movie" }
            val review = Review(
                review = reviewDTO.review,
                postedDate = OffsetDateTime.now().withNano(0).format(DATE_FORMAT),
                lastUpdatedAt = OffsetDateTime.now().withNano(0).format(DATE_FORMAT),
                movieName = reviewDTO.movieName,
                ratting = reviewDTO.ratting
            )
            return reviewRepository.save(review)
        }
    }

    fun getReviews(movieName: String): Flux<Review> {
        return reviewRepository.findByMovieName(movieName)
    }
}
