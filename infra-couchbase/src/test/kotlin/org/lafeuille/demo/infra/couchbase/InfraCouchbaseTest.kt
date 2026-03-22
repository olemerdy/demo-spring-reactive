package org.lafeuille.demo.infra.couchbase

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.data.couchbase.autoconfigure.DataCouchbaseReactiveAutoConfiguration
import org.springframework.boot.data.couchbase.test.autoconfigure.DataCouchbaseTest
import org.springframework.context.annotation.Import
import org.springframework.data.couchbase.core.ReactiveCouchbaseTemplate
import reactor.kotlin.test.test
import java.time.Instant
import java.util.UUID

@Import(CouchbaseContainerTestConfiguration::class)
@DataCouchbaseTest
@ImportAutoConfiguration(DataCouchbaseReactiveAutoConfiguration::class)
class InfraCouchbaseTest(
    @Autowired val couchbaseTemplate: ReactiveCouchbaseTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        couchbaseTemplate
            .insertById(SampleData::class.java)
            .one(data)
            .then(
                couchbaseTemplate
                    .findById(SampleData::class.java)
                    .one(data.id),
            ).test()
            .expectNext(data)
            .verifyComplete()
    }
}
