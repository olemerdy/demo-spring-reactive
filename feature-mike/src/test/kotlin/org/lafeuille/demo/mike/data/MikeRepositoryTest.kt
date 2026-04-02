package org.lafeuille.demo.mike.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@Import(MongoContainerTestConfiguration::class)
@DataMongoTest
class MikeRepositoryTest(
    @Autowired private val repository: MikeRepository,
) {
    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}
