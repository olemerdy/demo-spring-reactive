package org.lafeuille.demo.books.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.neo4j.InfraDataReactiveNeo4jConfiguration
import org.lafeuille.demo.neo4j.Neo4jContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.kotlin.test.test

@DataNeo4jTest
@Import(
    InfraDataReactiveNeo4jConfiguration::class,
    Neo4jContainerTestConfiguration::class
)
class BookRepositoryTest(
    @Autowired private val repository: BookRepository
) {

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}