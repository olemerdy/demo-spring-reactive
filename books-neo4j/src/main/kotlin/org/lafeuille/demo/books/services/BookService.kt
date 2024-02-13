package org.lafeuille.demo.books.services

import org.lafeuille.demo.books.data.Book
import org.lafeuille.demo.books.data.BookRepository
import org.lafeuille.demo.books.domain.BookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BookService(
    private val repository: BookRepository,
) {
    fun getBooks(pageable: Pageable): Mono<Page<BookResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Book> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getBook(isbn: String): Mono<BookResponse> =
        repository.findById(isbn)
            .map { it.toResponse() }

    fun deleteBook(isbn: String): Mono<Void> = repository.deleteById(isbn)
}
