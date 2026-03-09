package org.lafeuille.demo.infra.elasticsearch

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class ElasticsearchContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun elasticsearchContainer(): ElasticsearchContainer =
        ElasticsearchContainer(DockerImageName.parse(ElasticsearchDefaults.DOCKER_IMAGE_NAME))
            .withEnv("xpack.security.enabled", "" + false)
}