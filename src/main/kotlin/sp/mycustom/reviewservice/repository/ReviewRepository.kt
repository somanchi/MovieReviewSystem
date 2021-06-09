package sp.mycustom.reviewservice.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import sp.mycustom.reviewservice.entities.Review

@Repository
interface ReviewRepository : ReactiveCrudRepository<Review, String> {

    fun findByMovieName(movieName: String): Flux<Review>
}
