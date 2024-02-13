package org.lafeuille.demo.books.web

import org.hibernate.validator.constraints.ISBN
import org.lafeuille.demo.books.domain.BookResponse
import org.lafeuille.demo.books.services.BookService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class BooksController(
    private val service: BookService,
) {
    @GetMapping
    fun readBooks(pageable: Pageable): Mono<Page<BookResponse>> = service.getBooks(pageable)

    @GetMapping("{isbn}")
    fun readBook(
        @PathVariable @ISBN isbn: String,
    ): Mono<ResponseEntity<BookResponse>> =
        service.getBook(isbn)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("{isbn}")
    fun deleteBook(
        @PathVariable @ISBN isbn: String,
    ): Mono<Void> = service.deleteBook(isbn)
}
