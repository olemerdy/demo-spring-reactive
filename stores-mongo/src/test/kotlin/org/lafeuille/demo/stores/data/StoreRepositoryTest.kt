package org.lafeuille.demo.stores.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.stores.StoresContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@DataMongoTest
@Import(StoresContainerTestConfiguration::class)
class StoreRepositoryTest(
    @Autowired private val repository: StoreRepository
) {

    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}