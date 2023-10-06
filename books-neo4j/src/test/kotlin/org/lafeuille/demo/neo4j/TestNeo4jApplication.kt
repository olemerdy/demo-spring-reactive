package org.lafeuille.demo.neo4j

import org.lafeuille.demo.Application
import org.lafeuille.demo.neo4j.infra.Neo4jDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.Neo4jContainer

@TestConfiguration(proxyBeanMethods = false)
class TestNeo4jApplication {
    @Bean
    @ServiceConnection
    fun neo4j() = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestNeo4jApplication::class).run(*args)
}