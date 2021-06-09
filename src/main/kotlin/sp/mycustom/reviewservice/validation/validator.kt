package sp.mycustom.reviewservice.validation

import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.entities.Movie

inline fun <T> withReviewValidation(movie: Mono<Movie>, function: () -> T): T {
    isMovieNameValidInReview(movie.block())
    isMovieReleased(movie.block())
    return function()
}

