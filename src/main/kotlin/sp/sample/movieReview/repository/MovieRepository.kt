package sp.sample.movieReview.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import sp.sample.movieReview.entities.Movie

@Repository
interface MovieRepository : ReactiveCrudRepository<Movie, String> {
    fun findByMovieName(movieName: String): Mono<Movie>
}
