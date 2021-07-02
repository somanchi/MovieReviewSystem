package sp.mycustom.reviewservice.exception

import org.springframework.http.HttpStatus

class MovieNotFoundException (
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val errorMessage: String
) : ReviewsRunTimeException(status, errorMessage)