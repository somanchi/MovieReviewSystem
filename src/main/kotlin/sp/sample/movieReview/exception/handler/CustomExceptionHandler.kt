package sp.sample.movieReview.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import sp.sample.movieReview.exception.ReviewsRunTimeException

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(ReviewsRunTimeException::class)
    fun exceptionHandler(e: ReviewsRunTimeException): ResponseEntity<String> {
        return ResponseEntity(e.errorMessage, e.status)
    }
}
