package sp.mycustom.reviewservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.ReviewDTO
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.service.ReviewService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class ReviewMutationController {

    @Autowired
    lateinit var reviewService: ReviewService

    @Operation(
        summary = "Add new Review",
        description = "Add new review for the movie",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "review added for the movie"
            )
        ]
    )

    @Tag(name = "Reviews", description = "APIs to Mutate & Query reviews")
    @PostMapping("/review/addnewreview")
    fun addNewReview(
        @RequestBody review: ReviewDTO
    ): Mono<Review> {
        return reviewService.addReview(reviewDTO = review)
    }
}
