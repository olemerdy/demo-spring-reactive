package org.lafeuille.demo.books.web

import org.hibernate.validator.constraints.ISBN
import org.lafeuille.demo.books.domain.BookResponse
import org.lafeuille.demo.books.services.BookService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class BooksController(
    private val service: BookService,
) {
    @GetMapping
    fun readBooks(pageable: Pageable): Mono<PagedModel<BookResponse>> = service.getBooks(pageable).map { PagedModel(it) }

    @GetMapping("{isbn}")
    fun readBook(
        @PathVariable @ISBN(type = ISBN.Type.ANY) isbn: String,
    ): Mono<ResponseEntity<BookResponse>> =
        service
            .getBook(isbn)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(
        @PathVariable @ISBN(type = ISBN.Type.ANY) isbn: String,
    ): Mono<Unit> = service.deleteBook(isbn)
}
