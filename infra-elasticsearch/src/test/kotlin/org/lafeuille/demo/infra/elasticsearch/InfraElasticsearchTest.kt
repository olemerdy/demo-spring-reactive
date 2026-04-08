package org.lafeuille.demo.infra.elasticsearch

import org.junit.jupiter.api.Test
import org.lafeuille.demo.data.SampleDataFixtures
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.elasticsearch.test.autoconfigure.DataElasticsearchTest
import org.springframework.context.annotation.Import
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate
import org.springframework.data.elasticsearch.core.get
import reactor.kotlin.test.test

@Import(ElasticsearchContainerTestConfiguration::class)
@DataElasticsearchTest
class InfraElasticsearchTest(
    @Autowired val elasticsearchTemplate: ReactiveElasticsearchTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = SampleDataFixtures.ID, value = SampleDataFixtures.VALUE, timestamp = SampleDataFixtures.INSTANT)
        elasticsearchTemplate
            .save(data)
            .then(elasticsearchTemplate.get<SampleData>(SampleDataFixtures.ID_STRING))
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
