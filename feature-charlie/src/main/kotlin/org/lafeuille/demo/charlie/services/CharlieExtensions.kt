package org.lafeuille.demo.charlie.services

import org.lafeuille.demo.charlie.data.Charlie
import org.lafeuille.demo.charlie.domain.CharlieResponse

internal fun Charlie.toResponse() =
    CharlieResponse(
        id = this.id,
    )
