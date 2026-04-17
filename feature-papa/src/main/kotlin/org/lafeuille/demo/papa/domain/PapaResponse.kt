package org.lafeuille.demo.papa.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.util.UUID

data class PapaResponse(
    val id: UUID,
    @field:NotBlank @field:Size(max = PapaConstants.Sizes.NAME) val name: String,
    @field:NotNull val birthDate: LocalDate,
)
