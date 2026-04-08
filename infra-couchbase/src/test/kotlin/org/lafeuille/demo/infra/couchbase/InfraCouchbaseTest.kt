package org.lafeuille.demo.infra.couchbase

import org.junit.jupiter.api.Test
import org.lafeuille.demo.data.SampleDataFixtures
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.data.couchbase.autoconfigure.DataCouchbaseReactiveAutoConfiguration
import org.springframework.boot.data.couchbase.test.autoconfigure.DataCouchbaseTest
import org.springframework.context.annotation.Import
import org.springframework.data.couchbase.core.ReactiveCouchbaseTemplate
import reactor.kotlin.test.test

@Import(CouchbaseContainerTestConfiguration::class)
@DataCouchbaseTest
@ImportAutoConfiguration(DataCouchbaseReactiveAutoConfiguration::class)
class InfraCouchbaseTest(
    @Autowired val couchbaseTemplate: ReactiveCouchbaseTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = SampleDataFixtures.ID, value = SampleDataFixtures.VALUE, timestamp = SampleDataFixtures.INSTANT)
        couchbaseTemplate
            .insertById(SampleData::class.java)
            .one(data)
            .then(
                couchbaseTemplate
                    .findById(SampleData::class.java)
                    .one(SampleDataFixtures.ID_STRING),
            ).test()
            .expectNext(data)
            .verifyComplete()
    }
}
