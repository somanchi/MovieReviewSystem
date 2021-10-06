package sp.sample.movie.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.sample.movie.dto.MovieDTO
import sp.sample.movie.entities.Movie
import sp.sample.movie.service.MovieService
import sp.sample.movie.utils.API_VERSION
import javax.validation.Valid

@RestController
@RequestMapping(API_VERSION)
@Validated
@Tag(name = "Movie")
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
    @PostMapping("/movie")
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
