package sp.sample.movieReview.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration
import sp.sample.movieReview.utils.API_VERSION

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "Movie Review System",
        version = API_VERSION,
        description = "This application gives ratting and reviews to the movies"
    ),
    servers = [
        Server(url = "http://localhost:8080", description = "localhost")
    ]
)
class OpenApiConfig
