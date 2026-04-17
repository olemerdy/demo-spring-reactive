package org.lafeuille.demo.echo.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.lafeuille.demo.echo.domain.EchoFixtures
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.elasticsearch.test.autoconfigure.DataElasticsearchTest
import org.springframework.context.annotation.Import
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate
import reactor.kotlin.test.test

@Import(ElasticsearchContainerTestConfiguration::class)
@DataElasticsearchTest
class EchoRepositoryTest(
    @Autowired private val repository: EchoRepository,
    @Autowired private val elasticsearchTemplate: ReactiveElasticsearchTemplate,
) {
    @BeforeEach
    fun setUp() {
        repository
            .deleteAll()
            .test()
            .verifyComplete()
    }

    @Test
    fun test() {
        val echo = Echo(EchoFixtures.ISBN13)
        repository
            .save(echo)
            .then(
                elasticsearchTemplate.get(EchoFixtures.ISBN13, Echo::class.java),
            ).test()
            .assertNext {
                assertThat(it).isNotNull
                assertThat(it.isbn).isEqualTo(EchoFixtures.ISBN13)
                assertThat(it.version).isEqualTo(1)
            }.verifyComplete()
    }
}
