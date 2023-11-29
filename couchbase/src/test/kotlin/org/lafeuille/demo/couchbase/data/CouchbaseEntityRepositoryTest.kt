package org.lafeuille.demo.couchbase.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.couchbase.CouchbaseContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.couchbase.DataCouchbaseTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@DataCouchbaseTest(properties = ["spring.data.couchbase.bucket-name=test"])
@Import(CouchbaseContainerTestConfiguration::class)
class CouchbaseEntityRepositoryTest(
    @Autowired private val repository: CouchbaseEntityRepository
) {

    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}