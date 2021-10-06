package sp.sample.movie.dto

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

data class ReviewDTO(
    @Size(min = 10, max = 255)
    val review: String,
    @Size(min = 2, max = 15)
    val movieName: String,
    @Min(value = 0)
    @Max(value = 10)
    val ratting: Int
)
