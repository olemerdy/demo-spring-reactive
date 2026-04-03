package org.lafeuille.demo.mike.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.lafeuille.demo.mike.domain.MikeFixtures
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
    fun test_findAll() {
        repository
            .findAll()
            .test()
            .verifyComplete()
    }

    @Test
    fun test_save() {
        val mike = MikeFixtures.defaultMike()
        repository
            .save(mike)
            .test()
            .expectNext(mike.copy(version = 0))
            .verifyComplete()
    }
}
