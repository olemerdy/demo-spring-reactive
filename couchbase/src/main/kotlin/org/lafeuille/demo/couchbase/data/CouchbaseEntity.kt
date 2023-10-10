package org.lafeuille.demo.couchbase.data

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.Instant
import java.util.*

data class CouchbaseEntity(
    @Id val id: UUID = UUID.randomUUID(),
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null
)