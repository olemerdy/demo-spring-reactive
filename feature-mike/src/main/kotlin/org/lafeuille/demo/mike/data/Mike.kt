package org.lafeuille.demo.mike.data

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.net.URI
import java.time.Duration
import java.time.Instant
import java.time.Month
import java.time.Period
import java.util.Currency
import java.util.Locale
import java.util.UUID

@Document(collection = "mikes")
data class Mike(
    @Id val id: UUID = UUID.randomUUID(),
    val name: String,
    val locale: Locale,
    val currency: Currency,
    val location: Point,
    val duration: Duration,
    val period: Period,
    val month: Month,
    val uri: URI,
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null,
    @DocumentReference(lazy = true) val parent: Mike? = null,
    // List, Map<String, X>
)
