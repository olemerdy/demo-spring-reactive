package org.lafeuille.demo.books.data

import org.hibernate.validator.constraints.ISBN
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.Instant

data class Book(
    @Id @ISBN val isbn: String,
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null
)