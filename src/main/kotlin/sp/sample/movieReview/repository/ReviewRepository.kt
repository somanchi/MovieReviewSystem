package sp.sample.movieReview.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import sp.sample.movieReview.entities.Review

@Repository
interface ReviewRepository : ReactiveCrudRepository<Review, String> {

    fun findByMovieName(movieName: String): Flux<Review>
}
