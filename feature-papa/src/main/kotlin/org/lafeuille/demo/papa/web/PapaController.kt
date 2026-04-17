package org.lafeuille.demo.papa.web

import org.lafeuille.demo.papa.domain.PapaResponse
import org.lafeuille.demo.papa.services.PapaService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("api/papas")
class PapaController(
    private val service: PapaService,
) {
    @GetMapping
    fun readPapas(pageable: Pageable): Mono<PagedModel<PapaResponse>> = service.getPapas(pageable).map { PagedModel(it) }

    @GetMapping("{id}")
    fun readPapa(
        @PathVariable id: UUID,
    ): Mono<ResponseEntity<PapaResponse>> =
        service
            .getPapa(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePapa(
        @PathVariable id: UUID,
    ): Mono<Unit> = service.deletePapa(id)
}
