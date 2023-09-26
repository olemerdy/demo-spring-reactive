package org.lafeuille.demo.mongo.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import java.io.IOException

@JsonTest
class PersonResponseJsonTest(
    @Autowired private val jacksonTester: JacksonTester<PersonResponse>
) {

    @Test
    @Throws(IOException::class)
    fun serialize() {
        val personResponse = PersonResponse(
            id = PersonDefaults.ID,
            name = PersonDefaults.NAME,
            birthDate = PersonDefaults.BIRTH_DATE
        )
        val jsonContent = jacksonTester.write(personResponse)
        assertThat(jsonContent).isEqualToJson("PersonResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val (id, name, birthDate) = jacksonTester.readObject("PersonResponse.json")
        assertThat(id).isEqualTo(PersonDefaults.ID)
        assertThat(name).isEqualTo(PersonDefaults.NAME)
        assertThat(birthDate).isEqualTo(PersonDefaults.BIRTH_DATE)
    }
}