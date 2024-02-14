package org.lafeuille.demo.people.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.r2dbc.R2dbcContainerTestConfiguration
import org.lafeuille.demo.people.domain.PersonFixtures
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import reactor.kotlin.test.test

@DataR2dbcTest
@Import(R2dbcContainerTestConfiguration::class)
class PersonRepositoryTest(
    @Autowired private val template: R2dbcEntityTemplate,
    @Autowired private val repository: PersonRepository,
) {
    @Test
    fun find_person_page() {
        repository.findBy(Pageable.ofSize(10))
            .test()
            .assertNext { (id, name, birthDate): Person ->
                assertThat(id).isEqualTo(PersonFixtures.ID)
                assertThat(name).isEqualTo(PersonFixtures.NAME)
                assertThat(birthDate).isEqualTo(PersonFixtures.BIRTH_DATE)
            }.assertNext { (id, name, birthDate): Person ->
                assertThat(id).isEqualTo(PersonFixtures.OTHER_ID)
                assertThat(name).isEqualTo(PersonFixtures.OTHER_NAME)
                assertThat(birthDate).isEqualTo(PersonFixtures.OTHER_BIRTH_DATE)
            }.verifyComplete()
    }

    @Test
    fun find_person_by_id() {
        repository.findById(PersonFixtures.ID)
            .test()
            .assertNext { (id, name, birthDate): Person ->
                assertThat(id).isEqualTo(PersonFixtures.ID)
                assertThat(name).isEqualTo(PersonFixtures.NAME)
                assertThat(birthDate).isEqualTo(PersonFixtures.BIRTH_DATE)
            }.verifyComplete()
    }
}
