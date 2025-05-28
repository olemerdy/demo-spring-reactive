package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.ContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@Import(ContainerTestConfiguration::class)
@AutoConfigureWebTestClient
class ApplicationTest(
    @Autowired private val webTestClient: WebTestClient,
) {
    @Test
    fun actuatorLoads() {
        webTestClient
            .get()
            .uri("/actuator/health")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.status")
            .isEqualTo("UP")
    }

    @Test
    fun peopleApiLoads() {
        webTestClient
            .get()
            .uri("/api/v1/people")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.content.length()")
            .isEqualTo(0)
    }
}
