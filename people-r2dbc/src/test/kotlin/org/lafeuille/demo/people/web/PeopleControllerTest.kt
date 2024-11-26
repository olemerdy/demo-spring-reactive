package org.lafeuille.demo.people.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.people.domain.PersonFixtures
import org.lafeuille.demo.people.domain.PersonResponse
import org.lafeuille.demo.people.services.PersonService
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.util.UUID

@WebFluxTest
class PeopleControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockitoBean
    private lateinit var service: PersonService

    @Test
    fun readPeople_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getPeople(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client.get().uri("/api/v1/people")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("totalPages").isEqualTo(0)
    }

    @Test
    fun readPerson_OK() {
        whenever(service.getPerson(any()))
            .thenReturn(
                Mono.just(
                    PersonResponse(
                        id = PersonFixtures.ID,
                        name = PersonFixtures.NAME,
                        birthDate = PersonFixtures.BIRTH_DATE,
                    ),
                ),
            )

        client.get().uri("/api/v1/people/{id}", PersonFixtures.ID)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("id").isEqualTo(PersonFixtures.ID_STRING)
            .jsonPath("name").isEqualTo(PersonFixtures.NAME)
            .jsonPath("birthDate").isEqualTo(PersonFixtures.BIRTH_DATE.toString())
    }

    @Test
    fun readPerson_NOT_FOUND() {
        whenever(service.getPerson(any()))
            .thenReturn(Mono.empty())

        client.get().uri("/api/v1/people/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus().isNotFound
    }

    @Test
    fun deletePerson() {
        whenever(service.deletePerson(any()))
            .thenReturn(Mono.empty())

        client.delete().uri("/api/v1/people/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus().isNoContent
    }
}
