package org.lafeuille.demo.stores.web

import org.lafeuille.demo.stores.domain.StoreResponse
import org.lafeuille.demo.stores.services.StoreService
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
@RequestMapping("api/v1/stores")
class StoresController(
    private val service: StoreService,
) {
    @GetMapping
    fun readStores(pageable: Pageable): Mono<PagedModel<StoreResponse>> = service.getStores(pageable).map { PagedModel(it) }

    @GetMapping("{id}")
    fun readStore(
        @PathVariable id: UUID,
    ): Mono<ResponseEntity<StoreResponse>> =
        service.getStore(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
}
