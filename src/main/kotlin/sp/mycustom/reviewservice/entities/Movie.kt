package sp.mycustom.reviewservice.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import sp.mycustom.reviewservice.enums.FilmGenre
import java.net.URL
import java.util.UUID

@Document
data class Movie(
    val movieName: String,
    val releaseDate: String,
    val storyDescription: String,
    val tillerURL: URL,
    val posterURL: URL,
    val cast: Cast,
    val filmGenre: FilmGenre,
    @Id
    val movieId: String = UUID.nameUUIDFromBytes(movieName.toLowerCase().toByteArray()).toString()
)
