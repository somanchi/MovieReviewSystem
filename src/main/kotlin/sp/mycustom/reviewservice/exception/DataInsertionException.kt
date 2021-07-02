package sp.mycustom.reviewservice.exception

import org.springframework.http.HttpStatus

class DataInsertionException(
    override val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val errorMessage: String
) : ReviewsRunTimeException(status, errorMessage)
