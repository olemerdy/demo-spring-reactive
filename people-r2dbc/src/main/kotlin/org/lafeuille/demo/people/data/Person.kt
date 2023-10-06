package org.lafeuille.demo.people.data

import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.Instant
import java.time.LocalDate
import java.util.*

data class Person(
    @Id val id: UUID = UUID.randomUUID(),
    @field:NotNull val name: String,
    @field:NotNull val birthDate: LocalDate,
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null
)
