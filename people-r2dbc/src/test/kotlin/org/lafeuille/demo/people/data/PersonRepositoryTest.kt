package org.lafeuille.demo.people.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.r2dbc.PostgresDefaults
import org.lafeuille.demo.people.domain.PersonFixtures
import org.lafeuille.demo.people.domain.PersonFixtures.defaultNewPerson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import reactor.kotlin.test.test

@DataR2dbcTest
@Testcontainers
class PersonRepositoryTest(
    @Autowired private val template: R2dbcEntityTemplate,
    @Autowired private val repository: PersonRepository
) {

    @Test
    fun find_event_by_id() {
        template.insert(defaultNewPerson())
            .then(repository.findById(PersonFixtures.ID))
            .test()
            .assertNext { (id, name, birthDate): Person ->
                assertThat(id).isEqualTo(PersonFixtures.ID)
                assertThat(name).isEqualTo(PersonFixtures.NAME)
                assertThat(birthDate).hasToString("2001-01-01")
            }.verifyComplete()
    }

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        private val postgre: PostgreSQLContainer<*> = PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
    }
}