package org.lafeuille.demo.stores.data

import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import java.util.UUID

interface StoreRepository : ReactiveMongoRepository<Store, UUID> {
    fun findBy(pageable: Pageable): Flux<Store>
}
