package org.lafeuille.demo.infra

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.rabbitmq.RabbitMQContainer

@TestConfiguration(proxyBeanMethods = false)
class RabbitMQContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun rabbitContainer(): RabbitMQContainer = RabbitMQContainer(RabbitMQDefaults.DOCKER_IMAGE_NAME)
}
