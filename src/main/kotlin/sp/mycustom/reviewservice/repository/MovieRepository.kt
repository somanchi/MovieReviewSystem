package sp.mycustom.reviewservice.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.entities.Movie

@Repository
interface  MovieRepository : ReactiveCrudRepository<Movie,String> {
     fun findByMovieName(movieName : String) : Mono<Movie>
}