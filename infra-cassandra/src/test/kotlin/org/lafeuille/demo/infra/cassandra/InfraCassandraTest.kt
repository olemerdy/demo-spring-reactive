package org.lafeuille.demo.infra.cassandra

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.cassandra.test.autoconfigure.DataCassandraTest
import org.springframework.context.annotation.Import
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate
import org.springframework.test.context.TestPropertySource
import reactor.kotlin.test.test
import java.time.Instant
import java.util.UUID

@Import(CassandraContainerTestConfiguration::class)
@TestPropertySource(
    properties = [
        "spring.data.cassandra.keyspace-name=test_keyspace",
        "spring.data.cassandra.schema-action=RECREATE_DROP_UNUSED",
    ],
)
@DataCassandraTest
class InfraCassandraTest(
    @Autowired val cassandraTemplate: ReactiveCassandraTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        cassandraTemplate
            .insert(data)
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
