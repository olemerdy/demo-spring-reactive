package org.lafeuille.demo.elasticsearch.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.elasticsearch.TestElasticsearchApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest
import org.springframework.context.annotation.Import

@DataElasticsearchTest
@Import(TestElasticsearchApplication::class)
class ElasticsearchRepositoryTest(
    @Autowired private val repository: ElasticsearchEntityRepository
) {
    @Test
    fun test() {
    }
}