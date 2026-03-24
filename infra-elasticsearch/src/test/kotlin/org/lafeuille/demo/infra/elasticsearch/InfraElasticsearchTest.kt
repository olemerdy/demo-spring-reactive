package org.lafeuille.demo.infra.elasticsearch

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.elasticsearch.test.autoconfigure.DataElasticsearchTest
import org.springframework.context.annotation.Import
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate
import reactor.kotlin.test.test
import java.time.Instant
import java.util.UUID

@Import(ElasticsearchContainerTestConfiguration::class)
@DataElasticsearchTest
class InfraElasticsearchTest(
    @Autowired val elasticsearchTemplate: ReactiveElasticsearchTemplate
) {
    @Test
    fun test() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        elasticsearchTemplate.save(data)
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}