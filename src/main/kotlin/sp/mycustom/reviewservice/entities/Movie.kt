package sp.mycustom.reviewservice.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import java.util.UUID

@Document
data class Movie(
    val movieName: String,
    @Id
    val id: String = getUUID(movieName),
    val releaseDate: String,
    val storyDescription: String,
    val tillerURL: String?,
    val posterURL: String?,
    val cast: Cast?
)

fun getUUID(movieName: String): String {
    return UUID.nameUUIDFromBytes(movieName.toLowerCase().toByteArray()).toString()
}
