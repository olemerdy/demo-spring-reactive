package org.lafeuille.demo.charlie.data

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Flux
import java.util.UUID

interface CharlieRepository : ReactiveCouchbaseRepository<Charlie, UUID> {
    fun findBy(pageable: Pageable): Flux<Charlie>
}
