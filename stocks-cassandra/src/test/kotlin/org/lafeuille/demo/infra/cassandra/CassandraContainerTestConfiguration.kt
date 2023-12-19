package org.lafeuille.demo.infra.cassandra

import org.lafeuille.demo.infra.cassandra.CassandraDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.CassandraContainer

@TestConfiguration(proxyBeanMethods = false)
class CassandraContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun cassandra() = CassandraContainer(CassandraDefaults.DOCKER_IMAGE_NAME)
}