package sp.sample.movie.validation

import sp.sample.movie.dto.ReviewDTO
import sp.sample.movie.entities.Movie
import sp.sample.movie.exception.MovieNotReleasedException
import java.time.OffsetDateTime
import java.time.ZoneOffset

inline fun <T> withReviewValidation(
    movie: Movie,
    reviewDTO: ReviewDTO,
    function: () -> T
): T {
    isMovieReleased(movie)
    return function()
}

fun isMovieReleased(movie: Movie) {
    val date1 = OffsetDateTime.parse(movie.releaseDate).withOffsetSameInstant(ZoneOffset.UTC)
    val date2 = OffsetDateTime.now().withNano(0).withOffsetSameInstant(ZoneOffset.UTC)
    if (compareValues(date1, date2) > 0)
        throw MovieNotReleasedException(errorMessage = "movie ${movie.movieName} is not released")
}
