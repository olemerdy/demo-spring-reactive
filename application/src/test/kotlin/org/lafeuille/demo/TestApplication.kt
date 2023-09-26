package org.lafeuille.demo

import org.lafeuille.demo.cassandra.infra.CassandraDefaults
import org.lafeuille.demo.mongo.infra.MongoDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.CassandraContainer
import org.testcontainers.containers.MongoDBContainer

@TestConfiguration(proxyBeanMethods = false)
class TestApplication {

    @Bean
    @ServiceConnection
    fun cassandra() = CassandraContainer(CassandraDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun mongoDb() = MongoDBContainer(MongoDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestApplication::class).run(*args)
}
