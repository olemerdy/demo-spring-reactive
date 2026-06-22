package org.lafeuille.demo.mike.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.mike.data.MikeFixtures
import org.lafeuille.demo.mike.services.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.context.annotation.Import
import org.springframework.data.web.config.SpringDataJackson3Configuration
import java.io.IOException

@JsonTest
@Import(SpringDataJackson3Configuration::class)
class MikeResponseTest(
    @Autowired private val jacksonTester: JacksonTester<MikeResponse>,
) {
    @Test
    @Throws(IOException::class)
    fun serialize() {
        val jsonContent = jacksonTester.write(MikeFixtures.defaultMike().toResponse())
        assertThat(jsonContent).isEqualToJson("MikeResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val mikeResponse = jacksonTester.readObject("MikeResponse.json")
        assertThat(mikeResponse).isEqualTo(MikeFixtures.defaultMike().toResponse())
    }
}
