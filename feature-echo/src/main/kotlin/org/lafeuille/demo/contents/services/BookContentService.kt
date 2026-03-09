package org.lafeuille.demo.contents.services

import org.lafeuille.demo.contents.data.BookContent
import org.lafeuille.demo.contents.data.BookContentRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BookContentService(
    private val repository: BookContentRepository,
) {
    fun getBookContent(isbn: String): Mono<BookContent> = repository.findById(isbn)
}
