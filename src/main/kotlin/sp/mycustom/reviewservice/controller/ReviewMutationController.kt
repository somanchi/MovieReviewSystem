package sp.mycustom.reviewservice.controller

import com.expediagroup.graphql.server.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.ReviewDTO
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.service.ReviewService

@Component
class ReviewMutationController : Query {

    @Autowired
    lateinit var reviewService: ReviewService

    fun addNewReview(
        @RequestBody review: ReviewDTO
    ): Mono<Review> {
        return reviewService.addReview(reviewDTO = review)
    }
}
