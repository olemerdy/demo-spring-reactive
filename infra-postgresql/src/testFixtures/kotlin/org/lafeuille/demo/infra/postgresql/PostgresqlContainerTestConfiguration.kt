package org.lafeuille.demo.infra.postgresql

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.postgresql.PostgreSQLContainer
import java.time.Duration

@TestConfiguration(proxyBeanMethods = false)
class PostgresqlContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun postgresql(): PostgreSQLContainer =
        PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
            .withMinimumRunningDuration(Duration.ofSeconds(3))
}
