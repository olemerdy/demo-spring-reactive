package org.lafeuille.demo.mongo.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.mongo.domain.PersonDefaults
import org.lafeuille.demo.mongo.infra.MongoDefaults
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import reactor.kotlin.test.test

@DataMongoTest
@Testcontainers
class PersonRepositoryTest(
    @Autowired private val template: ReactiveMongoTemplate,
    @Autowired private val repository: PersonRepository
) {

    @Test
    fun find_event_by_id() {
        template.insert(defaultNewPerson())
            .then(repository.findById(PersonDefaults.ID))
            .test()
            .assertNext { (id, name, birthDate): Person ->
                assertThat(id).isEqualTo(PersonDefaults.ID)
                assertThat(name).isEqualTo(PersonDefaults.NAME)
                assertThat(birthDate).hasToString("2001-01-01")
            }.verifyComplete()
    }

    private fun defaultNewPerson(): Person {
        return Person(
            id = PersonDefaults.ID,
            name = PersonDefaults.NAME,
            birthDate = PersonDefaults.BIRTH_DATE
        )
    }

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        private val mongoDb: MongoDBContainer = MongoDBContainer(MongoDefaults.DOCKER_IMAGE_NAME)
    }
}