package org.lafeuille.demo.neo4j

import org.lafeuille.demo.infra.neo4j.Neo4jDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.Neo4jContainer

@TestConfiguration(proxyBeanMethods = false)
class Neo4jContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun neo4j() = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)
}