package org.lafeuille.demo.charlie.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.couchbase.CouchbaseContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.couchbase.test.autoconfigure.DataCouchbaseTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@DataCouchbaseTest
@Import(CouchbaseContainerTestConfiguration::class)
class CharlieRepositoryTest(
    @Autowired val repository: CharlieRepository,
) {
    @Test
    fun test_findAll() {
        repository
            .findAll()
            .test()
            .verifyComplete()
    }

    @Test
    fun test_save() {
        val charlie = CharlieFixtures.defaultCharlie()
        repository
            .save(charlie)
            .test()
            .expectNext(charlie)
            .verifyComplete()
    }
}
