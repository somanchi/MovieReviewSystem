package sp.mycustom.reviewservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.service.MovieService
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class MovieController {

    @Autowired
    lateinit var movieService: MovieService

    @PostMapping("/insert/movie/")
    fun addNewMovie(@RequestBody movie: MovieDTO): Mono<Movie> {
        return movieService.addMovie(movie)
    }

    @GetMapping("/movies")
    fun getMovies(): Flux<Movie> {
        return movieService.getAllMovies()
    }
}
