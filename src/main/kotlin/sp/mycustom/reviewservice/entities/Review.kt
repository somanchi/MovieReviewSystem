package sp.mycustom.reviewservice.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import sp.mycustom.reviewservice.enums.ReviewContentType
import java.util.UUID

@Document
data class Review(
    val review: String,
    val postedDate: String,
    val lastUpdatedAt: String,
    val movieName: String,
    val movieId: String,
    val ratting: Int,
    val isEdited: Boolean = postedDate != lastUpdatedAt,
    @Id
    val reviewId: String = UUID.randomUUID().toString(),
    val reviewContentType: ReviewContentType = ReviewContentType.NonSensitive
)
