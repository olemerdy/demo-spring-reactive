package org.lafeuille.demo.infra.redis

import com.redis.testcontainers.RedisContainer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean

@TestConfiguration(proxyBeanMethods = false)
class RedisContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun redisContainer(): RedisContainer = RedisContainer(RedisDefaults.DOCKER_IMAGE_NAME)
}
