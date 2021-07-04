package sp.sample.movieReview.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.sample.movieReview.dto.MovieDTO
import sp.sample.movieReview.entities.Movie
import sp.sample.movieReview.service.MovieService
import sp.sample.movieReview.utils.API_VERSION
import javax.validation.Valid

@RestController
@RequestMapping(API_VERSION)
@Validated
class MovieController {

    @Autowired
    lateinit var movieService: MovieService

    @Operation(
        summary = "Add New Movie",
        description = "A json of newly added movie will be returned",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Returns added movie details"
            )
        ]
    )
    @PostMapping("/insert/movie/")
    fun addNewMovie(@Valid @RequestBody movie: MovieDTO): Mono<Movie> {
        return movieService.addMovie(movie)
    }

    @Operation(
        summary = "Get All movies available",
        description = "A json of movies will be returned",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Returns movies details"
            )
        ]
    )
    @GetMapping("/movies")
    fun getMovies(): Flux<Movie> {
        return movieService.getAllMovies()
    }
}
