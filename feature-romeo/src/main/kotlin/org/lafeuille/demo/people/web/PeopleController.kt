package org.lafeuille.demo.people.web

import org.lafeuille.demo.people.domain.PersonResponse
import org.lafeuille.demo.people.services.PersonService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("api/v1/people")
class PeopleController(
    private val service: PersonService,
) {
    @GetMapping
    fun readPeople(pageable: Pageable): Mono<PagedModel<PersonResponse>> = service.getPeople(pageable).map { PagedModel(it) }

    @GetMapping("{id}")
    fun readPerson(
        @PathVariable id: UUID,
    ): Mono<ResponseEntity<PersonResponse>> =
        service
            .getPerson(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(
        @PathVariable id: UUID,
    ): Mono<Unit> = service.deletePerson(id)
}
