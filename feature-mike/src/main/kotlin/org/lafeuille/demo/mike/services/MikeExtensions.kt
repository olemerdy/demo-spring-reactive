package org.lafeuille.demo.mike.services

import org.lafeuille.demo.mike.data.Mike
import org.lafeuille.demo.mike.domain.MikeResponse

internal fun Mike.toResponse() =
    MikeResponse(
        id = this.id,
        name = this.name,
        location = this.location,
    )
