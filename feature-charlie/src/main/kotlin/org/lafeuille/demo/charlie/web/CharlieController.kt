package org.lafeuille.demo.charlie.web

import org.lafeuille.demo.charlie.domain.CharlieResponse
import org.lafeuille.demo.charlie.services.CharlieService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("api/charlies")
class CharlieController(
    private val service: CharlieService,
) {
    @GetMapping
    fun readCharlies(pageable: Pageable): Mono<PagedModel<CharlieResponse>> = service.getCharlies(pageable).map { PagedModel(it) }

    @GetMapping("{id}")
    fun readMike(
        @PathVariable id: UUID,
    ): Mono<ResponseEntity<CharlieResponse>> =
        service
            .getCharlie(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("{id}")
    fun deleteMike(
        @PathVariable id: UUID,
    ): Mono<Void> = service.deleteCharlie(id)
}
