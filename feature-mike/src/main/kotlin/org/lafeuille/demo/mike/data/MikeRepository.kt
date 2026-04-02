package org.lafeuille.demo.mike.data

import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import java.util.UUID

interface MikeRepository : ReactiveMongoRepository<Mike, UUID> {
    fun findBy(pageable: Pageable): Flux<Mike>
}
