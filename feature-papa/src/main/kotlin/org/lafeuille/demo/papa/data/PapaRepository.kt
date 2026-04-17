package org.lafeuille.demo.papa.data

import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import java.util.UUID

interface PapaRepository : R2dbcRepository<Papa, UUID> {
    fun findBy(pageable: Pageable): Flux<Papa>
}
