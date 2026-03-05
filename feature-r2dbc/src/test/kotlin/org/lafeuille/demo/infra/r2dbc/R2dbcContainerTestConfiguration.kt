package org.lafeuille.demo.infra.r2dbc

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import java.time.Duration

@TestConfiguration(proxyBeanMethods = false)
class R2dbcContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun postgresql(): PostgreSQLContainer<*> =
        PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
            .withMinimumRunningDuration(Duration.ofSeconds(3))
}
