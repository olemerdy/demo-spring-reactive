package org.lafeuille.demo.contents.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest
import org.springframework.context.annotation.Import
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate
import reactor.kotlin.test.test

@DataElasticsearchTest
@Import(ElasticsearchContainerTestConfiguration::class)
class BookContentRepositoryTest(
    @Autowired private val repository: BookContentRepository,
    @Autowired private val elasticsearchTemplate: ReactiveElasticsearchTemplate,
) {
    @BeforeEach
    fun setUp() {
        repository.deleteAll()
            .test()
            .verifyComplete()
    }

    @Test
    fun test() {
        val bookContent = BookContent("9788466729222")
        repository.save(bookContent)
            .then(
                elasticsearchTemplate.get("9788466729222", BookContent::class.java),
            )
            .test()
            .assertNext {
                assertThat(it).isNotNull
                assertThat(it.isbn).isEqualTo("9788466729222")
                assertThat(it.version).isEqualTo(1)
            }
            .verifyComplete()
    }
}
