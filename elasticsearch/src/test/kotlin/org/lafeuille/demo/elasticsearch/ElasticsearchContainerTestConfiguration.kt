package org.lafeuille.demo.elasticsearch

import org.lafeuille.demo.infra.elasticsearch.ElasticsearchDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.elasticsearch.ElasticsearchContainer

@TestConfiguration(proxyBeanMethods = false)
class ElasticsearchContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun elasticsearch() = ElasticsearchContainer(ElasticsearchDefaults.DOCKER_IMAGE_NAME)
}