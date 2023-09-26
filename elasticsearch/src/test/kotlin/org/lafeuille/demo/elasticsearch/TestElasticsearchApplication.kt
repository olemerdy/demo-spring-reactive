package org.lafeuille.demo.elasticsearch

import org.lafeuille.demo.Application
import org.lafeuille.demo.elasticsearch.infra.ElasticsearchDefaults
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.elasticsearch.ElasticsearchContainer

@TestConfiguration(proxyBeanMethods = false)
class TestElasticsearchApplication {
    @Bean
    @ServiceConnection
    fun elasticsearch() = ElasticsearchContainer(ElasticsearchDefaults.DOCKER_IMAGE_NAME)
}

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestElasticsearchApplication::class).run(*args)
}