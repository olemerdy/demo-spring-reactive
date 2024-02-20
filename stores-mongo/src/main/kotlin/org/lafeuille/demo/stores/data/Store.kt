package org.lafeuille.demo.stores.data

import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.geo.Point
import java.time.Instant
import java.util.UUID

data class Store(
    @Id val id: UUID = UUID.randomUUID(),
    @field:NotNull val name: String,
    @field:NotNull val location: Point,
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null,
)
