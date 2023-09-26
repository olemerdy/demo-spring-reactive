package org.lafeuille.demo.r2dbc

import org.lafeuille.demo.Application
import org.lafeuille.demo.r2dbc.infra.PostgresDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class TestR2dbcApplication {
    @Bean
    @ServiceConnection
    fun postgresql() = PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestR2dbcApplication::class).run(*args)
}