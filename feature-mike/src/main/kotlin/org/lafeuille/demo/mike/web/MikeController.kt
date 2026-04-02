package org.lafeuille.demo.mike.web

import org.lafeuille.demo.mike.domain.MikeResponse
import org.lafeuille.demo.mike.services.MikeService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("api/mikes")
class MikeController(
    private val service: MikeService,
) {
    @GetMapping
    fun readMikes(pageable: Pageable): Mono<PagedModel<MikeResponse>> = service.getMikes(pageable).map { PagedModel(it) }

    @GetMapping("{id}")
    fun readMike(
        @PathVariable id: UUID,
    ): Mono<ResponseEntity<MikeResponse>> =
        service
            .getMike(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
}
