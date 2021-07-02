package sp.mycustom.reviewservice.dto

import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class ReviewDTO(
    val review: String,
    val movieName: String,

    @Min(value = 0)
    @Max(value = 10)
    val ratting: Int
)
