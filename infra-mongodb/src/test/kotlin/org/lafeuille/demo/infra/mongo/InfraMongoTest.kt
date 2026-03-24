package org.lafeuille.demo.infra.mongo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import reactor.kotlin.test.test
import java.time.Instant
import java.util.UUID

@Import(MongoContainerTestConfiguration::class)
@DataMongoTest
class InfraMongoTest(
    @Autowired val mongoTemplate: ReactiveMongoTemplate,
) {
    @Test
    fun test() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        mongoTemplate
            .save(data)
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
