package sp.mycustom.reviewservice.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import java.util.UUID

@Document
data class Review(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val review: String,
    val postedDate: String,
    val lastUpdatedAt: String,
    val isEdited: Boolean = postedDate != lastUpdatedAt,
    val movieName: String,
    val ratting: Int
)
