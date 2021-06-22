package sp.mycustom.reviewservice.controller

import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.service.MovieService

@Component
class MovieMutationController : Mutation {

    @Autowired
    lateinit var movieService: MovieService

    fun addNewReview(
        @RequestBody movie: MovieDTO
    ): Mono<Movie> {
        return movieService.addMovie(movie)
    }
}
