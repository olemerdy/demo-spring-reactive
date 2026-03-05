package org.lafeuille.demo.people.domain

import java.time.LocalDate
import java.time.Month
import java.util.UUID

object PersonFixtures {
    const val ID_STRING = "e1c47fc3-472d-4c14-8d7a-c1b4d1dbdfe5"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val NAME = "John Doe"

    val BIRTH_DATE: LocalDate by lazy { LocalDate.of(2001, Month.JANUARY, 1) }

    private const val OTHER_ID_STRING = "b5130fc9-aec2-4a54-b2ae-a709195041cf"
    val OTHER_ID: UUID by lazy { UUID.fromString(OTHER_ID_STRING) }

    const val OTHER_NAME = "Jane Doe"

    val OTHER_BIRTH_DATE: LocalDate by lazy { LocalDate.of(2002, Month.FEBRUARY, 2) }
}
