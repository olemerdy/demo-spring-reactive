package org.lafeuille.demo.books.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import java.io.IOException

@JsonTest
class BookResponseJsonTest(
    @Autowired private val jacksonTester: JacksonTester<BookResponse>,
) {
    @Test
    @Throws(IOException::class)
    fun serialize() {
        val personResponse =
            BookResponse(
                isbn = BookFixtures.ISBN,
            )
        val jsonContent = jacksonTester.write(personResponse)
        assertThat(jsonContent).isEqualToJson("BookResponse.json")
    }

    @Test
    @Throws(IOException::class)
    fun deserialize() {
        val (isbn) = jacksonTester.readObject("BookResponse.json")
        assertThat(isbn).isEqualTo(BookFixtures.ISBN)
    }
}
