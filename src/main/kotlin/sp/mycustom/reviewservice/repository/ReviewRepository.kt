package sp.mycustom.reviewservice.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import sp.mycustom.reviewservice.entities.Review

@Repository
interface ReviewRepository : ReactiveCrudRepository<Review, String>