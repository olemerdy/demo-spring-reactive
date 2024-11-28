package org.lafeuille.demo.people.services

import org.lafeuille.demo.people.data.Person
import org.lafeuille.demo.people.data.PersonRepository
import org.lafeuille.demo.people.domain.PersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.cast
import java.util.UUID

@Service
class PersonService(
    private val repository: PersonRepository,
) {
    fun getPeople(pageable: Pageable): Mono<Page<PersonResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Person> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getPerson(id: UUID): Mono<PersonResponse> =
        repository.findById(id)
            .map { it.toResponse() }

    @Transactional
    fun deletePerson(id: UUID): Mono<Unit> = repository.deleteById(id).cast()
}
