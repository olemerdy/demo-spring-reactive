package org.lafeuille.demo.infra.cassandra

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.cassandra.CassandraContainer

@TestConfiguration(proxyBeanMethods = false)
class CassandraContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun cassandraContainer(): CassandraContainer =
        CassandraContainer(CassandraDefaults.DOCKER_IMAGE_NAME)
            .withInitScript("init.cql")
}
