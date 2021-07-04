package sp.sample.movieReview.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.sample.movieReview.dto.ReviewDTO
import sp.sample.movieReview.entities.Review
import sp.sample.movieReview.service.ReviewService
import sp.sample.movieReview.utils.API_VERSION
import javax.validation.Valid

@RestController
@RequestMapping(API_VERSION)
@Validated
class ReviewController {

    @Autowired
    lateinit var reviewService: ReviewService

    @Operation(
        summary = "Add New Review",
        description = "A json of newly added review will be returned",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Returns added review details"
        )]
    )
    @PostMapping("/insert/review/")
    fun addNewReview(@Valid @RequestBody review: ReviewDTO): Mono<Review> {
        return reviewService.addReview(reviewDTO = review)
    }

    @Operation(
        summary = "Get Reviews",
        description = "A List of reviews will be returned for the given movie name",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Returns List of reviews"
        )]
    )
    @GetMapping("/reviews/{movieName}")
    fun getReview(@PathVariable movieName: String): Flux<Review> {
        return reviewService.getReviews(movieName)
    }
}
