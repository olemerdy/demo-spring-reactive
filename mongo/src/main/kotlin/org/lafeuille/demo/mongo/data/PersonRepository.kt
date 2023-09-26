package org.lafeuille.demo.mongo.data

import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import java.util.*

interface PersonRepository : ReactiveMongoRepository<Person, UUID> {
    fun findBy(pageable: Pageable): Flux<Person>
}