package sp.sample.movieReview.validation

import sp.sample.movieReview.entities.Movie
import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneOffset
import kotlin.math.abs

inline fun <T> withReviewValidation(movie: Movie, function: () -> T): T {
    isMovieReleased(movie)
    return function()
}

fun isMovieReleased(movie: Movie): Boolean {
    val date1 = OffsetDateTime.parse(movie.releaseDate).withOffsetSameInstant(ZoneOffset.UTC)
    val date2 = OffsetDateTime.now().withNano(0).withOffsetSameInstant(ZoneOffset.UTC)
    return abs(Duration.between(date1, date2).toDays()) == 0L
}
