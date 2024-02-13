package org.lafeuille.demo.people.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.util.UUID

data class PersonResponse(
    val id: UUID,
    @field:NotBlank @field:Size(max = PersonConstants.Sizes.NAME) val name: String,
    @field:NotNull val birthDate: LocalDate,
)
