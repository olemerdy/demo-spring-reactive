package org.lafeuille.demo.books.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.neo4j.InfraDataReactiveNeo4jConfiguration
import org.lafeuille.demo.infra.neo4j.Neo4jDefaults
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.Neo4jContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import reactor.kotlin.test.test

@DataNeo4jTest
@Import(InfraDataReactiveNeo4jConfiguration::class)
@Testcontainers
class BookRepositoryTest(
    @Autowired private val repository: BookRepository
) {

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    fun test() {
        repository.findAll().test().verifyComplete()
    }

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        private val neo4j: Neo4jContainer<*> = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)
    }
}