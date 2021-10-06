package sp.sample.movie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieReviewSystemApplication

fun main(args: Array<String>) {
    runApplication<MovieReviewSystemApplication>(*args)
}
