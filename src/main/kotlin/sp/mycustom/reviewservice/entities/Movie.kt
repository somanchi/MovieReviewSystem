package sp.mycustom.reviewservice.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import java.util.UUID

@Document
data class Movie(
    @Id
    var id: String = UUID.randomUUID().toString(),
    val movieName: String,
    val releaseDate: String,
    val storyDescription: String,
    val tillerURL: String?,
    val posterURL: String?,
    val cast: Cast?
)
