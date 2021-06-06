package sp.mycustom.reviewservice.controller

import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sp.mycustom.reviewservice.utils.API_VERSION

@RestController
@RequestMapping(API_VERSION)
class HealthController {

    private val log: KLogger = KotlinLogging.logger {}

    @GetMapping("/health")
    fun healthController(): ResponseEntity<String> {
        log.info { "inside health check" }
        return ResponseEntity("server is running ",HttpStatus.OK)
    }
}