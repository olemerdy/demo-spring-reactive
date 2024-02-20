package org.lafeuille.demo.stores.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.stores.domain.StoreFixtures
import org.lafeuille.demo.stores.domain.StoreFixtures.defaultStoreResponse
import org.lafeuille.demo.stores.services.StoreService
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.util.UUID

@WebFluxTest
class StoresControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockBean
    private lateinit var service: StoreService

    @Test
    fun readStores_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getStores(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client.get().uri("/api/v1/stores")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("totalPages").isEqualTo(0)
    }

    @Test
    fun readStore_OK() {
        whenever(service.getStore(any()))
            .thenReturn(Mono.just(defaultStoreResponse()))

        client.get().uri("/api/v1/stores/{id}", StoreFixtures.ID)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("id").isEqualTo(StoreFixtures.ID_STRING)
            .jsonPath("name").isEqualTo(StoreFixtures.NAME)
            .jsonPath("location.x").isEqualTo(0)
            .jsonPath("location.y").isEqualTo(0)
    }

    @Test
    fun readStore_NOT_FOUND() {
        whenever(service.getStore(any()))
            .thenReturn(Mono.empty())

        client.get().uri("/api/v1/stores/{id}", UUID.randomUUID())
            .exchange()
            .expectStatus().isNotFound
    }
}
