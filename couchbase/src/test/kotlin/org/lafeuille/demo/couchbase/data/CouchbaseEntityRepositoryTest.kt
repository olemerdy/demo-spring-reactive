package org.lafeuille.demo.couchbase.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.couchbase.CouchbaseDefaults
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.couchbase.DataCouchbaseTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.couchbase.BucketDefinition
import org.testcontainers.couchbase.CouchbaseContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import reactor.kotlin.test.test
import java.time.Duration

@DataCouchbaseTest
@Testcontainers
class CouchbaseEntityRepositoryTest(
    @Autowired private val repository: CouchbaseEntityRepository
) {

    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        private val couchbase: CouchbaseContainer =
            CouchbaseContainer(CouchbaseDefaults.DOCKER_IMAGE_NAME)
                .withStartupTimeout(Duration.ofMinutes(5))
                .withBucket(BucketDefinition("test"))
    }
}