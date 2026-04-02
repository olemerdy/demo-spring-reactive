package org.lafeuille.demo.mike.domain

import org.springframework.data.geo.Point
import java.util.UUID

object MikeFixtures {
    const val ID_STRING = "ed41a7d0-1f7e-4f92-a91f-b6fe99384f3f"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val NAME = "Mickey"

    const val LOCATION_X: Double = 123.0
    const val LOCATION_Y: Double = 456.0
    val LOCATION: Point by lazy { Point(LOCATION_X, LOCATION_Y) }

    fun defaultMikeResponse() = MikeResponse(id = ID, name = NAME, location = LOCATION)
}
