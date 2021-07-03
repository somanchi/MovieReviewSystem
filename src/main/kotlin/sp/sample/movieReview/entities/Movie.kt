package sp.sample.movieReview.entities

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import sp.sample.movieReview.enums.FilmGenre
import java.util.UUID

@Document
data class Movie(
    val movieName: String,
    val releaseDate: String,
    val storyDescription: String,
    val tillerURL: String,
    val posterURL: String,
    val cast: Cast,
    val filmGenre: FilmGenre,
    @Id
    val movieId: String = UUID.nameUUIDFromBytes(movieName.toLowerCase().toByteArray()).toString()
)
