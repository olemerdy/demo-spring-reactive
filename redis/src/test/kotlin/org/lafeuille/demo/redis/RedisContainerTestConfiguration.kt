package org.lafeuille.demo.redis

import org.lafeuille.demo.infra.redis.RedisDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer

@TestConfiguration(proxyBeanMethods = false)
class RedisContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun redis() = GenericContainer(RedisDefaults.DOCKER_IMAGE_NAME)
}