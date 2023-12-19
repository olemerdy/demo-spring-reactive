package org.lafeuille.demo.books.data

import org.springframework.data.domain.Pageable
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import reactor.core.publisher.Flux

interface BookRepository : ReactiveNeo4jRepository<Book, String> {
    fun findBy(pageable: Pageable): Flux<Book>
}
