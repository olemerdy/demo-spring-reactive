package org.lafeuille.demo.contents.web

import org.hibernate.validator.constraints.ISBN
import org.lafeuille.demo.contents.data.BookContent
import org.lafeuille.demo.contents.services.BookContentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/books/{isbn}/content")
class BookContentController(
    private val service: BookContentService,
) {
    @GetMapping
    fun readBookContent(
        @PathVariable @ISBN(type = ISBN.Type.ANY) isbn: String,
    ): Mono<ResponseEntity<BookContent>> =
        service
            .getBookContent(isbn)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
}
