package org.lafeuille.demo.infra.kafka

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.kafka.KafkaContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class KafkaContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun cassandraContainer(): KafkaContainer = KafkaContainer(DockerImageName.parse(KafkaDefaults.DOCKER_IMAGE_NAME))
}
