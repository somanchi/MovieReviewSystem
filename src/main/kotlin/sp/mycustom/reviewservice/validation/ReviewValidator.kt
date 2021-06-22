package sp.mycustom.reviewservice.validation

import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.exception.ReviewsRunTimeException
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun isMovieNameValidInReview(movie: Movie?) {
    if (movie == null) {
        throw ReviewsRunTimeException(errorMessage = "Movie Not found")
    }
}

fun isMovieReleased(movie: Movie?) {
    movie?.let {
        if (compareValues(
                OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                it.releaseDate
            ) < 0
        ) {
            throw ReviewsRunTimeException(errorMessage = "Movie Not Released")
        }
    }
}
