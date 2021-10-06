package sp.sample.movie.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import sp.sample.movie.entities.Cast
import sp.sample.movie.entities.Movie
import sp.sample.movie.enums.FilmGenre

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ValidationTest {

    @Test
    fun `should not throw error when movie is released`() {
        val movie = Movie("some","2011-12-03T10:14:30+00:00","some",
        "","", Cast("","","",""),FilmGenre.Comedy)
        assertDoesNotThrow {
            withReviewValidation(movie){
                println(movie)
            }
        }
    }
}