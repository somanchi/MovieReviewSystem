package sp.mycustom.reviewservice.dto

import sp.mycustom.reviewservice.entities.Cast
import sp.mycustom.reviewservice.enums.FilmGenre
import java.net.URL
import java.time.OffsetDateTime
import javax.validation.constraints.Size

data class MovieDTO(
    @Size(min = 2, max = 15)
    val movieName: String,
    val releaseDate: OffsetDateTime,
    @Size(min = 10, max = 255)
    val storyDescription: String,
    val tillerURL: URL,
    val posterURL: URL,
    val cast: Cast,
    val filmGenre: FilmGenre
)
