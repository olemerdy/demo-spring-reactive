package org.lafeuille.demo.infra.neo4j

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.neo4j.Neo4jContainer

@TestConfiguration(proxyBeanMethods = false)
class Neo4JContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun neo4jContainer(): Neo4jContainer = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)
}
