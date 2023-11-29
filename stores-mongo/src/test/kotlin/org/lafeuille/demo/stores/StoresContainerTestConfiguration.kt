package org.lafeuille.demo.stores

import org.lafeuille.demo.infra.mongo.MongoDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer

@TestConfiguration(proxyBeanMethods = false)
class StoresContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun mongoDb() = MongoDBContainer(MongoDefaults.DOCKER_IMAGE_NAME)
}