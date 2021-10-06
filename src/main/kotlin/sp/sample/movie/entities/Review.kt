package sp.sample.movie.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import sp.sample.movie.enums.ReviewContentType
import java.util.UUID

@Document
data class Review(
    val review: String,
    val postedDate: String,
    val lastUpdatedAt: String,
    val movieName: String,
    val movieId: String,
    val ratting: Double,
    val isEdited: Boolean = postedDate != lastUpdatedAt,
    @Id
    val reviewId: String = UUID.randomUUID().toString(),
    val reviewContentType: ReviewContentType = ReviewContentType.NonSensitive
)
