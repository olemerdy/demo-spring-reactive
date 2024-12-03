package org.lafeuille.demo.books.web

import org.junit.jupiter.api.Test
import org.lafeuille.demo.books.domain.BookFixtures
import org.lafeuille.demo.books.domain.BookResponse
import org.lafeuille.demo.books.services.BookService
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@WebFluxTest
class BooksControllerTest(
    @Autowired private val client: WebTestClient,
) {
    @MockitoBean
    private lateinit var service: BookService

    @Test
    fun readBooks_OK() {
        val pageRequest = PageRequest.of(0, 20)

        whenever(service.getBooks(pageRequest))
            .thenReturn(Mono.just(PageImpl(listOf(), pageRequest, 0)))

        client.get().uri("/api/v1/books")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("page.size").isEqualTo(20)
            .jsonPath("page.number").isEqualTo(0)
            .jsonPath("page.totalElements").isEqualTo(0)
            .jsonPath("page.totalPages").isEqualTo(0)
    }

    @Test
    fun readBook_OK() {
        whenever(service.getBook(BookFixtures.ISBN))
            .thenReturn(Mono.just(BookResponse(BookFixtures.ISBN)))

        client.get().uri("/api/v1/books/{isbn}", BookFixtures.ISBN)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("isbn").isEqualTo(BookFixtures.ISBN)
    }

    @Test
    fun readBook_NOT_FOUND() {
        whenever(service.getBook(BookFixtures.ISBN))
            .thenReturn(Mono.empty())

        client.get().uri("/api/v1/books/{isbn}", BookFixtures.ISBN)
            .exchange()
            .expectStatus().isNotFound
    }

    @Test
    fun readBook_BAD_REQUEST() {
        client.get().uri("/api/v1/books/{isbn}", "ABC")
            .exchange()
            .expectStatus().isBadRequest
    }

    @Test
    fun deleteBook_NO_CONTENT() {
        whenever(service.deleteBook(any()))
            .thenReturn(Mono.empty())

        client.delete().uri("/api/v1/books/{isbn}", BookFixtures.ISBN)
            .exchange()
            .expectStatus().isNoContent
    }

    @Test
    fun deleteBook_BAD_REQUEST() {
        client.delete().uri("/api/v1/books/{isbn}", "ABC")
            .exchange()
            .expectStatus().isBadRequest
    }
}
