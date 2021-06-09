package sp.mycustom.reviewservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.service.ReviewService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class ReviewQueryController {

    @Autowired
    lateinit var reviewService: ReviewService

    @Operation(
        summary = "get all reviews",
        description = "get all reviews by movie name",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "reviews by movie name"
            )
        ]
    )

    @Tag(name = "Reviews", description = "APIs to Mutate & Query reviews")
    @GetMapping("/reviews/{movieName}")
    fun getReview(
        @PathVariable movieName: String
    ): Flux<Review> {
        return reviewService.getReviews(movieName)
    }
}
