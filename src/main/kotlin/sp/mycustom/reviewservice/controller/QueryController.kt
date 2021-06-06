package sp.mycustom.reviewservice.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.entities.Review
import sp.mycustom.reviewservice.service.MovieService
import sp.mycustom.reviewservice.service.ReviewService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class QueryController {

    @Autowired
    lateinit var reviewService: ReviewService

    @Autowired
    lateinit var movieService: MovieService

    @Tag(name = "Reviews", description = "APIs to Mutate & get reviews")
    @GetMapping("/reviews")
    fun getReview(): Flux<Review> {
       return reviewService.getReviews()
    }

    @Tag(name = "Movie", description = "APIs to Mutate & get movies")
    @GetMapping("/movies")
    fun getMovies(): Flux<Movie> {
        return movieService.getAllMovies()
    }
}