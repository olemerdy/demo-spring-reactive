package org.lafeuille.demo.charlie.data

import java.util.UUID

object CharlieFixtures {
    const val ID_STRING = "5475bb64-39d3-40f0-a808-d273a66f3553"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    fun defaultCharlie() = Charlie(ID)
}
