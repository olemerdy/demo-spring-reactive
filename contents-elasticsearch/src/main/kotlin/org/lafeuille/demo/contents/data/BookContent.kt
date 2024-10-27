package org.lafeuille.demo.contents.data

import org.hibernate.validator.constraints.ISBN
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.elasticsearch.annotations.Document
import java.time.Instant

@Document(indexName = "entities")
data class BookContent(
    @Id @ISBN val isbn: String,
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null,
)
