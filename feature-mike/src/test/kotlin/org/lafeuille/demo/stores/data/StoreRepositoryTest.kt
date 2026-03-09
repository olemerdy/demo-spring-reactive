package org.lafeuille.demo.stores.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@Import(MongoContainerTestConfiguration::class)
@DataMongoTest
class StoreRepositoryTest(
    @Autowired private val repository: StoreRepository,
) {
    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}
