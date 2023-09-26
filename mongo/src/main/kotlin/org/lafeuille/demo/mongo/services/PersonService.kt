package org.lafeuille.demo.mongo.services

import org.lafeuille.demo.mongo.data.Person
import org.lafeuille.demo.mongo.data.PersonRepository
import org.lafeuille.demo.mongo.domain.PersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import java.util.*

@Service
class PersonService(private val repository: PersonRepository) {

    fun getPeople(pageable: Pageable): Mono<Page<PersonResponse>> {
        return Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList()
        ) { count: Long, list: List<Person> ->
            PageImpl(list, pageable, count).map { person ->
                responseFromPerson(person)
            }
        }
    }

    fun getPerson(id: UUID): Mono<PersonResponse> {
        return repository.findById(id)
            .map { responseFromPerson(it) }
    }

    @Transactional
    fun deletePerson(id: UUID): Mono<Void> {
        return repository.deleteById(id)
    }
}
