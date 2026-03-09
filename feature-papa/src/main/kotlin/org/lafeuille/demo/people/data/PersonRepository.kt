package org.lafeuille.demo.people.data

import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import java.util.UUID

interface PersonRepository : R2dbcRepository<Person, UUID> {
    fun findBy(pageable: Pageable): Flux<Person>
}
