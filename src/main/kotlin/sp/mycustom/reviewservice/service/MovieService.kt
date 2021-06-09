package sp.mycustom.reviewservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.repository.MovieRepository
import sp.mycustom.reviewservice.utils.DATE_FORMAT
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Service
class MovieService {

    @Autowired
    lateinit var movieRepository: MovieRepository

    fun addMovie(movieDTO: MovieDTO): Mono<Movie> {
        val movie = movieRepository.findByMovieName(movieDTO.movieName).block()
        if (movie == null) {
            val m = Movie(
                movieName = movieDTO.movieName,
                storyDescription = movieDTO.storyDescription,
                releaseDate = OffsetDateTime.parse(movieDTO.releaseDate).format(DATE_FORMAT),
                cast = null, posterURL = null, tillerURL = null
            )
            return movieRepository.save(m)
        } else {
            movie.let {
                return movieRepository.save(
                    Movie(
                        id = it.id, movieName = movieDTO.movieName,
                        storyDescription = movieDTO.storyDescription,
                        releaseDate = movieDTO.releaseDate,
                        cast = null, posterURL = null, tillerURL = null
                    )
                )
            }
        }
        return Mono.empty()
    }

    fun getAllMovies(): Flux<Movie> {
        return movieRepository.findAll()
    }

    fun getMovieByName(movieName: String): Mono<Movie> {
        return movieRepository.findByMovieName(movieName)
    }
}
