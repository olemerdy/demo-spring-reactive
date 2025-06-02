package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(properties = ["spring.docker.compose.skip.in-tests=false"])
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
