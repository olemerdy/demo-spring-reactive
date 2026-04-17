package org.lafeuille.demo.echo.web

import org.hibernate.validator.constraints.ISBN
import org.lafeuille.demo.echo.data.Echo
import org.lafeuille.demo.echo.services.EchoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/echoes/{isbn}/content")
class EchoController(
    private val service: EchoService,
) {
    @GetMapping
    fun readBookContent(
        @PathVariable @ISBN(type = ISBN.Type.ANY) isbn: String,
    ): Mono<ResponseEntity<Echo>> =
        service
            .getEcho(isbn)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
}
