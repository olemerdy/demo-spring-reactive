package org.lafeuille.demo.mike.domain

import org.springframework.data.geo.Point
import java.util.UUID

data class MikeResponse(
    val id: UUID,
    val name: String,
    val location: Point,
)
