package org.lafeuille.demo.redis

import org.lafeuille.demo.Application
import org.lafeuille.demo.redis.infra.RedisDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer

@TestConfiguration(proxyBeanMethods = false)
class TestRedisApplication {
    @Bean
    @ServiceConnection
    fun redis() = GenericContainer(RedisDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestRedisApplication::class).run(*args)
}