package org.lafeuille.demo.mike.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.mike.domain.MikeFixtures
import org.lafeuille.demo.mike.services.MikeService
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
class MikeControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockitoBean
    private lateinit var service: MikeService

    @Test
    fun readMikes_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getMikes(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client
            .get()
            .uri("/api/mikes")
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
    fun readMike_OK() {
        whenever(service.getMike(any()))
            .thenReturn(Mono.just(MikeFixtures.defaultMikeResponse()))

        client
            .get()
            .uri("/api/mikes/{id}", MikeFixtures.ID)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("id")
            .isEqualTo(MikeFixtures.ID_STRING)
            .jsonPath("name")
            .isEqualTo(MikeFixtures.NAME)
            .jsonPath("location.x")
            .isEqualTo(MikeFixtures.LOCATION_X)
            .jsonPath("location.y")
            .isEqualTo(MikeFixtures.LOCATION_Y)
    }

    @Test
    fun readMike_NOT_FOUND() {
        whenever(service.getMike(any()))
            .thenReturn(Mono.empty())

        client
            .get()
            .uri("/api/mikes/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isNotFound
    }
}
