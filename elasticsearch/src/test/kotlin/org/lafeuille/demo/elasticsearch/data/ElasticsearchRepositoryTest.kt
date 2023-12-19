package org.lafeuille.demo.elasticsearch.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@DataElasticsearchTest
@Import(ElasticsearchContainerTestConfiguration::class)
class ElasticsearchRepositoryTest(
    @Autowired private val repository: ElasticsearchEntityRepository
) {
    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}