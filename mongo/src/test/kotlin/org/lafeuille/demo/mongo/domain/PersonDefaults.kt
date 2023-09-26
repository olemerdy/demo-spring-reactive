package org.lafeuille.demo.mongo.domain

import java.time.Instant
import java.time.LocalDate
import java.time.Month
import java.util.*

object PersonDefaults {

    const val ID_STRING = "e1c47fc3-472d-4c14-8d7a-c1b4d1dbdfe5"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val NAME = "John Doe"

    val BIRTH_DATE: LocalDate by lazy { LocalDate.of(2001, Month.JANUARY, 1) }

    val CREATED_DATE = Instant.EPOCH

    val LAST_MODIFIED_DATE = Instant.EPOCH

    const val OTHER_ID_STRING = "b5130fc9-aec2-4a54-b2ae-a709195041cf"
    val OTHER_ID: UUID by lazy { UUID.fromString(OTHER_ID_STRING) }

    const val OTHER_NAME = "Jane Doe"
}