package sp.sample.movie.exception

import org.springframework.http.HttpStatus

class MovieNotReleasedException(
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val errorMessage: String
) : ReviewsRunTimeException(status, errorMessage)