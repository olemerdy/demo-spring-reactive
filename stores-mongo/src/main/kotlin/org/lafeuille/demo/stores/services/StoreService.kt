package org.lafeuille.demo.stores.services

import org.lafeuille.demo.stores.data.Store
import org.lafeuille.demo.stores.data.StoreRepository
import org.lafeuille.demo.stores.domain.StoreResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class StoreService(
    private val repository: StoreRepository,
) {
    fun getStores(pageable: Pageable): Mono<Page<StoreResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Store> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getStore(id: UUID): Mono<StoreResponse> =
        repository.findById(id)
            .map { it.toResponse() }
}
