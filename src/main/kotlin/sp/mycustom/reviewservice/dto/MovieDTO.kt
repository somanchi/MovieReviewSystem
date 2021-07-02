package sp.mycustom.reviewservice.dto

import sp.mycustom.reviewservice.entities.Cast
import sp.mycustom.reviewservice.enums.FilmGenre
import java.time.OffsetDateTime
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class MovieDTO(

    @Size(min = 2, max = 15)
    val movieName: String,
    val releaseDate: OffsetDateTime,
    @Size(min = 10, max = 255)
    val storyDescription: String,
    @Pattern(regexp = "^https?://(www.)?[-a-zA-Z0-9@:%._+~#=]{1,256}.[a-zA-Z0-9()]{1,6}b([-a-zA-Z0-9()@:%_+.~#?&//=])*$")
    val tillerURL: String,
    @Pattern(regexp = "^https?://(www.)?[-a-zA-Z0-9@:%._+~#=]{1,256}.[a-zA-Z0-9()]{1,6}b([-a-zA-Z0-9()@:%_+.~#?&//=])*$")
    val posterURL: String,
    val cast: Cast,
    val filmGenre: FilmGenre
)
