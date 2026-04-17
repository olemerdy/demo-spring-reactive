package org.lafeuille.demo.papa.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.papa.domain.PapaFixtures
import org.lafeuille.demo.papa.domain.PapaResponse
import org.lafeuille.demo.papa.services.PapaService
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
class PapaControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockitoBean
    private lateinit var service: PapaService

    @Test
    fun readPapas_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getPapas(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client
            .get()
            .uri("/api/papas")
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
    fun readPapa_OK() {
        whenever(service.getPapa(any()))
            .thenReturn(
                Mono.just(
                    PapaResponse(
                        id = PapaFixtures.ID,
                        name = PapaFixtures.NAME,
                        birthDate = PapaFixtures.BIRTH_DATE,
                    ),
                ),
            )

        client
            .get()
            .uri("/api/papas/{id}", PapaFixtures.ID)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("id")
            .isEqualTo(PapaFixtures.ID_STRING)
            .jsonPath("name")
            .isEqualTo(PapaFixtures.NAME)
            .jsonPath("birthDate")
            .isEqualTo(PapaFixtures.BIRTH_DATE.toString())
    }

    @Test
    fun readPapa_NOT_FOUND() {
        whenever(service.getPapa(any()))
            .thenReturn(Mono.empty())

        client
            .get()
            .uri("/api/papas/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isNotFound
    }

    @Test
    fun deletePapa() {
        whenever(service.deletePapa(any()))
            .thenReturn(Mono.empty())

        client
            .delete()
            .uri("/api/papas/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isNoContent
    }
}
