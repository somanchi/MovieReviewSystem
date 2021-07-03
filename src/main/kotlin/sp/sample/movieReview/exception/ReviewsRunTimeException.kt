package sp.sample.movieReview.exception

import org.springframework.http.HttpStatus

open class ReviewsRunTimeException(
    open val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    open val errorMessage: String
) : Exception()
