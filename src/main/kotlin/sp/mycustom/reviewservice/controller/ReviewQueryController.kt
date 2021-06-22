package sp.mycustom.reviewservice.controller

import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.service.ReviewService

@Component
class ReviewQueryController : Mutation {

    @Autowired
    lateinit var reviewService: ReviewService

    fun getReview(
        @PathVariable movieName: String
    ): Flux<Review> {
        return reviewService.getReviews(movieName)
    }
}
