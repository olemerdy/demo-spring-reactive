package org.lafeuille.demo.elasticsearch.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchDefaults
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.junit.jupiter.Container
import reactor.kotlin.test.test

@DataElasticsearchTest
class ElasticsearchRepositoryTest(
    @Autowired private val repository: ElasticsearchEntityRepository
) {
    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        private val elasticsearch: ElasticsearchContainer =
            ElasticsearchContainer(ElasticsearchDefaults.DOCKER_IMAGE_NAME)
    }
}