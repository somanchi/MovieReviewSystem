package sp.mycustom.reviewservice.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration
import sp.mycustom.reviewservice.utils.API_VERSION

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "Movie Reviews",
        version = API_VERSION,
        description = "This application gives ratting and reviews to the movies"
    ),
    servers = [
        Server(url = "http://localhost:8080", description = "P"),
        Server(url = "http://localhost:8090")
    ]
)
class OpenApiConfig
