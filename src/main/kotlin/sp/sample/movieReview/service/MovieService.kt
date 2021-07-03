package sp.sample.movieReview.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.sample.movieReview.dto.MovieDTO
import sp.sample.movieReview.entities.Movie
import sp.sample.movieReview.exception.DataFetchException
import sp.sample.movieReview.exception.DataInsertionException
import sp.sample.movieReview.repository.MovieRepository
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Service
class MovieService {

    private val log: KLogger = KotlinLogging.logger {}

    @Autowired
    lateinit var movieRepository: MovieRepository

    fun addMovie(movie: MovieDTO): Mono<Movie> {
        log.info("Adding movie $movie")
        try {
            return movieRepository.save(
                Movie(
                    movieName = movie.movieName,
                    filmGenre = movie.filmGenre,
                    cast = movie.cast,
                    tillerURL = movie.tillerURL,
                    posterURL = movie.posterURL,
                    releaseDate = movie.releaseDate.withOffsetSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    storyDescription = movie.storyDescription
                )
            )
        } catch (e: Exception) {
            throw DataInsertionException(errorMessage = "Failed to insert movie $movie")
        }
    }

    fun getAllMovies(): Flux<Movie> {
        try {
            return movieRepository.findAll()
        } catch (e: Exception) {
            throw DataFetchException(errorMessage = "Failed to fetch movies")
        }
    }

    fun getMovieById(movieId: String): Mono<Movie> {
        try {
            return movieRepository.findById(movieId)
        } catch (e: Exception) {
            throw DataFetchException(errorMessage = "Failed to fetch movie $movieId")
        }
    }
}
