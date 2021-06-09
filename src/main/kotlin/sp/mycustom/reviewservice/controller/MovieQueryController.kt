package sp.mycustom.reviewservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.service.MovieService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class MovieQueryController {

    @Autowired
    lateinit var movieService: MovieService

    @Operation(
        summary = "Get all movies",
        description = "get all movies",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "get all movies"
            )
        ]
    )

    @Tag(name = "Movie", description = "APIs to Mutate & Query movies")
    @GetMapping("/movies")
    fun getMovies(): Flux<Movie> {
        return movieService.getAllMovies()
    }
}
