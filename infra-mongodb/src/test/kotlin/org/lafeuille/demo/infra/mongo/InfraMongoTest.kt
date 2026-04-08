package org.lafeuille.demo.infra.mongo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.data.SampleDataFixtures
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findById
import reactor.kotlin.test.test

@Import(MongoContainerTestConfiguration::class)
@DataMongoTest
class InfraMongoTest(
    @Autowired val mongoTemplate: ReactiveMongoTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = SampleDataFixtures.ID, value = SampleDataFixtures.VALUE, timestamp = SampleDataFixtures.INSTANT)
        mongoTemplate
            .save(data)
            .then(mongoTemplate.findById<SampleData>(SampleDataFixtures.ID))
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
