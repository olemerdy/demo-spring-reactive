package org.lafeuille.demo.infra.neo4j

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.neo4j.test.autoconfigure.DataNeo4jTest
import org.springframework.context.annotation.Import
import org.springframework.data.neo4j.core.ReactiveNeo4jTemplate
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.kotlin.test.test

@Import(value = [Neo4jContainerTestConfiguration::class, InfraDataReactiveNeo4jConfiguration::class])
@DataNeo4jTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class InfraNeo4jTest(
    @Autowired val neo4jTemplate: ReactiveNeo4jTemplate,
) {
    @Test
    fun test() {
        val movie = Movie("The Matrix")
        val neo = Person("Keanu Reeves", 1964, listOf(movie))

        neo4jTemplate
            .save(neo)
            .test()
            .expectNext(neo)
            .verifyComplete()
    }
}
