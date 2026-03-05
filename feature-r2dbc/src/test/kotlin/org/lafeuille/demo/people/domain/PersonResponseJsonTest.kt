package org.lafeuille.demo.people.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import java.io.IOException

@JsonTest
class PersonResponseJsonTest(
    @Autowired private val jacksonTester: JacksonTester<PersonResponse>,
) {
    @Test
    @Throws(IOException::class)
    fun serialize() {
        val personResponse =
            PersonResponse(
                id = PersonFixtures.ID,
                name = PersonFixtures.NAME,
                birthDate = PersonFixtures.BIRTH_DATE,
            )
        val jsonContent = jacksonTester.write(personResponse)
        assertThat(jsonContent).isEqualToJson("PersonResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val (id, name, birthDate) = jacksonTester.readObject("PersonResponse.json")
        assertThat(id).isEqualTo(PersonFixtures.ID)
        assertThat(name).isEqualTo(PersonFixtures.NAME)
        assertThat(birthDate).isEqualTo(PersonFixtures.BIRTH_DATE)
    }
}
