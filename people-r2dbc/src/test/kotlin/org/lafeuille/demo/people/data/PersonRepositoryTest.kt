package org.lafeuille.demo.people.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.r2dbc.R2dbcContainerTestConfiguration
import org.lafeuille.demo.people.domain.PersonFixtures
import org.lafeuille.demo.people.domain.PersonFixtures.defaultNewPerson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.context.annotation.Import
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import reactor.kotlin.test.test

@DataR2dbcTest
@Import(R2dbcContainerTestConfiguration::class)
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
}