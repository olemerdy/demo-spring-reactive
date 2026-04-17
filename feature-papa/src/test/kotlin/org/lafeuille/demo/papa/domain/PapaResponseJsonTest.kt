package org.lafeuille.demo.papa.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import java.io.IOException

@JsonTest
class PapaResponseJsonTest(
    @Autowired private val jacksonTester: JacksonTester<PapaResponse>,
) {
    @Test
    @Throws(IOException::class)
    fun serialize() {
        val papaResponse =
            PapaResponse(
                id = PapaFixtures.ID,
                name = PapaFixtures.NAME,
                birthDate = PapaFixtures.BIRTH_DATE,
            )
        val jsonContent = jacksonTester.write(papaResponse)
        assertThat(jsonContent).isEqualToJson("PapaResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val (id, name, birthDate) = jacksonTester.readObject("PapaResponse.json")
        assertThat(id).isEqualTo(PapaFixtures.ID)
        assertThat(name).isEqualTo(PapaFixtures.NAME)
        assertThat(birthDate).isEqualTo(PapaFixtures.BIRTH_DATE)
    }
}
