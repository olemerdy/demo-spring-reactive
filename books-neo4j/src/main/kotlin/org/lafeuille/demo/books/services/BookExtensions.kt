package org.lafeuille.demo.books.services

import org.lafeuille.demo.books.data.Book
import org.lafeuille.demo.books.domain.BookResponse

internal fun Book.toResponse() =
    BookResponse(
        isbn = this.isbn,
    )
