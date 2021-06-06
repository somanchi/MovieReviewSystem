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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ReviewService {

    private val log: KLogger = KotlinLogging.logger {}

    @Autowired
    lateinit var reviewRepository: ReviewRepository

    fun addReview(reviewDTO: ReviewDTO): Mono<Review> {
        log.info { "Adding Review for movie" }
        val review = Review(
            review = reviewDTO.review,
            postedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).toString(),
            lastUpdatedAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).toString(),
            movieName = reviewDTO.movieName,
            ratting = reviewDTO.ratting
        )
       return  reviewRepository.save(review)
    }


    fun getReviews(): Flux<Review> {
        return reviewRepository.findAll()
    }
}