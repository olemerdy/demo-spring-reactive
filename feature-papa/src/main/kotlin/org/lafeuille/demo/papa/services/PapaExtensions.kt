package org.lafeuille.demo.papa.services

import org.lafeuille.demo.papa.data.Papa
import org.lafeuille.demo.papa.domain.PapaResponse

internal fun Papa.toResponse() =
    PapaResponse(
        id = this.id,
        name = this.name,
        birthDate = this.birthDate,
    )
