package org.lafeuille.demo.people

import org.lafeuille.demo.infra.r2dbc.PostgresDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class PeopleContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun postgresql() = PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
}