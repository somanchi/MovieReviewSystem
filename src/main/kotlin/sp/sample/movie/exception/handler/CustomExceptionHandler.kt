package sp.sample.movie.exception.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import sp.sample.movie.exception.DataFetchException
import sp.sample.movie.exception.DataInsertionException
import sp.sample.movie.exception.MovieNotFoundException
import sp.sample.movie.exception.ReviewsRunTimeException

@ControllerAdvice
class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(
        ReviewsRunTimeException::class,
        DataFetchException::class,
        DataInsertionException::class
    )
    fun exceptionHandler(e: ReviewsRunTimeException): ResponseEntity<String> {
        return ResponseEntity(e.errorMessage, e.status)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MovieNotFoundException::class)
    fun clientSideExceptions(e: MovieNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.errorMessage, e.status)
    }
}
