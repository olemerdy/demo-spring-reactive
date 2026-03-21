package org.lafeuille.demo.infra.couchbase

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.couchbase.CouchbaseContainer

@TestConfiguration(proxyBeanMethods = false)
class CouchbaseContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun couchbaseContainer(): CouchbaseContainer = CouchbaseContainer(CouchbaseDefaults.DOCKER_IMAGE_NAME)
}
