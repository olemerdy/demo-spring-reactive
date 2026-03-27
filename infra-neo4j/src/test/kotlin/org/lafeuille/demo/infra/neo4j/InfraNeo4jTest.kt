package org.lafeuille.demo.infra.neo4j

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.neo4j.test.autoconfigure.DataNeo4jTest
import org.springframework.context.annotation.Import
import org.springframework.data.neo4j.core.ReactiveNeo4jTemplate
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.kotlin.test.test
import java.time.Instant
import java.util.UUID

@Import(value = [Neo4jContainerTestConfiguration::class, InfraDataReactiveNeo4jConfiguration::class])
@DataNeo4jTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class InfraNeo4jTest(
    @Autowired val neo4jTemplate: ReactiveNeo4jTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        neo4jTemplate
            .save(data)
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
