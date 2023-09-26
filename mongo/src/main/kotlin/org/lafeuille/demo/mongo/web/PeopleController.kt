package org.lafeuille.demo.mongo.web

import org.lafeuille.demo.mongo.domain.PersonResponse
import org.lafeuille.demo.mongo.services.PersonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/v1/people")
class PeopleController(
    private val service: PersonService
) {

    @GetMapping
    fun readPeople(pageable: Pageable): Mono<Page<PersonResponse>> {
        return service.getPeople(pageable)
    }

    @GetMapping("{id}")
    fun readPerson(@PathVariable id: UUID): Mono<ResponseEntity<PersonResponse>> {
        return service.getPerson(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("{id}")
    fun deletePerson(@PathVariable id: UUID): Mono<Void> {
        return service.deletePerson(id)
    }

}