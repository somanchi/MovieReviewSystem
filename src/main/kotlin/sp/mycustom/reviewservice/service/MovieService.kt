package sp.mycustom.reviewservice.service

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.repository.MovieRepository

@Service
class MovieService {

    private val log: KLogger = KotlinLogging.logger {}

    @Autowired
    lateinit var movieRepository: MovieRepository

    fun addMovie(movieDTO: MovieDTO): Mono<Movie> {
        val movie = movieRepository.findByMovieName(movieDTO.movieName)
        if (movie.toString().isEmpty()) {
            val m = Movie(
                movieName = movieDTO.movieName,
                storyDescription = movieDTO.storyDescription,
                releaseDate = movieDTO.releaseDate,
                cast = null, posterURL = null, tillerURL = null
            )
            return movieRepository.save(m)
        } else {
            movie.block()?.id?.let {
                return movieRepository.save(
                    Movie(
                        id = it, movieName = movieDTO.movieName,
                        storyDescription = movieDTO.storyDescription, releaseDate = movieDTO.releaseDate,
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
}
