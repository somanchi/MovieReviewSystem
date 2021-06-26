package sp.mycustom.reviewservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sp.mycustom.reviewservice.dto.MovieDTO
import sp.mycustom.reviewservice.entities.Movie
import sp.mycustom.reviewservice.repository.MovieRepository

@Service
class MovieService {

    @Autowired
    lateinit var movieRepository: MovieRepository

    fun addMovie(movieDTO: MovieDTO): Mono<Movie> {
        return movieRepository.save(
            Movie(
                movieName = movieDTO.movieName,
                storyDescription = movieDTO.storyDescription,
                releaseDate = movieDTO.releaseDate,
                cast = null, posterURL = null, tillerURL = null
            )
        )
    }

    fun getAllMovies(): Flux<Movie> {
        return movieRepository.findAll()
    }

    fun getMovieByName(movieName: String): Mono<Movie> {
        return movieRepository.findByMovieName(movieName)
    }
}
