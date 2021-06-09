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
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.service.MovieService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class MovieMutationController  {

    @Autowired
    lateinit var movieService: MovieService

    @Operation(
        summary = "Add new movie",
        description = "Add new movie",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "movie added"
            )
        ]
    )
    @Tag(name = "Movie", description = "APIs to Mutate & Query movies")
    @PostMapping("/review/addmovie")
    fun addNewReview(
        @RequestBody movie: MovieDTO
    ): Mono<Movie> {
        return movieService.addMovie(movie)
    }
}
