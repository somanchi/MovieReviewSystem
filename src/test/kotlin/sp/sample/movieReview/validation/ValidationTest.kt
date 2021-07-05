package sp.sample.movieReview.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import sp.sample.movieReview.entities.Cast
import sp.sample.movieReview.entities.Movie
import sp.sample.movieReview.enums.FilmGenre

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ValidationTest {

    @Test
    fun `should not throw error when movie is released`() {
        val movie = Movie("some","2011-12-03T10:14:30+00:00","some",
        "","", Cast("","","",""),FilmGenre.Comedy)
        assertDoesNotThrow {
            withValidation(movie){
                println(movie)
            }
        }
    }
}