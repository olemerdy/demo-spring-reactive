package org.lafeuille.demo.mike.services

import org.lafeuille.demo.mike.data.Mike
import org.lafeuille.demo.mike.domain.MikeResponse

internal fun Mike.toResponse() =
    MikeResponse(
        id = this.id,
        name = this.name,
        locale = this.locale,
        currency = this.currency,
        duration = this.duration,
        period = this.period,
        month = this.month,
        location = this.location,
        uri = this.uri,
    )
