package org.lafeuille.demo.charlie.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.couchbase.CouchbaseContainerTestConfiguration
import org.springframework.boot.data.couchbase.test.autoconfigure.DataCouchbaseTest
import org.springframework.context.annotation.Import

@DataCouchbaseTest
@Import(CouchbaseContainerTestConfiguration::class)
class CharlieRepositoryTest {
    @Test
    fun test() {}
}
