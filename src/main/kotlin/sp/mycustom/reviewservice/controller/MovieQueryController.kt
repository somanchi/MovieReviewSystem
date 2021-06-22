package sp.mycustom.reviewservice.controller

import com.expediagroup.graphql.server.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.service.MovieService

@Component
class MovieQueryController : Query {

    @Autowired
    lateinit var movieService: MovieService

    fun getMovies(): Flux<Movie> {
        return movieService.getAllMovies()
    }
}
