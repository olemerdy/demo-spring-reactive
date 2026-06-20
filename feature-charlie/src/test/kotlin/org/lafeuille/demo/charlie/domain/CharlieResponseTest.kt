package org.lafeuille.demo.charlie.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.charlie.data.CharlieFixtures
import org.lafeuille.demo.charlie.services.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import java.io.IOException

@JsonTest
class CharlieResponseTest(
    @Autowired private val jacksonTester: JacksonTester<CharlieResponse>,
) {
    @Test
    @Throws(IOException::class)
    fun serialize() {
        val jsonContent = jacksonTester.write(CharlieFixtures.defaultCharlie().toResponse())
        assertThat(jsonContent).isEqualToJson("CharlieResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val charlieResponse = jacksonTester.readObject("CharlieResponse.json")
        assertThat(charlieResponse).isEqualTo(CharlieFixtures.defaultCharlie().toResponse())
    }
}
