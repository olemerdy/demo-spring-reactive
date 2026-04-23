package org.lafeuille.demo.charlie.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.charlie.data.CharlieFixtures
import org.lafeuille.demo.charlie.services.CharlieService
import org.lafeuille.demo.charlie.services.toResponse
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.util.UUID

@WebFluxTest
class CharlieControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockitoBean
    private lateinit var service: CharlieService

    @Test
    fun readCharlies_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getCharlies(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client
            .get()
            .uri("/api/charlies")
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("page.size")
            .isEqualTo(20)
            .jsonPath("page.number")
            .isEqualTo(0)
            .jsonPath("page.totalElements")
            .isEqualTo(0)
            .jsonPath("page.totalPages")
            .isEqualTo(0)
    }

    @Test
    fun readCharlie_OK() {
        whenever(service.getCharlie(any()))
            .thenReturn(Mono.just(CharlieFixtures.defaultCharlie().toResponse()))

        client
            .get()
            .uri("/api/charlies/{id}", CharlieFixtures.ID)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("id")
            .isEqualTo(CharlieFixtures.ID_STRING)
    }

    @Test
    fun readMike_NOT_FOUND() {
        whenever(service.getCharlie(any()))
            .thenReturn(Mono.empty())

        client
            .get()
            .uri("/api/charlies/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isNotFound
    }
}
