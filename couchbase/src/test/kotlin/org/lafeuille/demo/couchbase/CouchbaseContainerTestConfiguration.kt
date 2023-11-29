package org.lafeuille.demo.couchbase

import org.lafeuille.demo.infra.couchbase.CouchbaseDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.couchbase.BucketDefinition
import org.testcontainers.couchbase.CouchbaseContainer
import java.time.Duration

@TestConfiguration(proxyBeanMethods = false)
class CouchbaseContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun couchbase(): CouchbaseContainer =
        CouchbaseContainer(CouchbaseDefaults.DOCKER_IMAGE_NAME)
            .withStartupTimeout(Duration.ofMinutes(5))
            .withBucket(BucketDefinition("test"))
}