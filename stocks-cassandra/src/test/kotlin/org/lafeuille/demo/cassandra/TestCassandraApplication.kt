package org.lafeuille.demo.cassandra

import org.lafeuille.demo.Application
import org.lafeuille.demo.infra.cassandra.CassandraDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.CassandraContainer

@TestConfiguration(proxyBeanMethods = false)
class TestCassandraApplication {
    @Bean
    @ServiceConnection
    fun cassandra() = CassandraContainer(CassandraDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestCassandraApplication::class).run(*args)
}