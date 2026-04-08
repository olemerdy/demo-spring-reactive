package org.lafeuille.demo.data

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset
import java.util.UUID

object SampleDataFixtures {
    const val ID_STRING = "7d3bb7ac-b5c1-4efd-b672-af52c43a98fb"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val VALUE = 123.0

    val LOCAL_DATE: LocalDate by lazy { LocalDate.of(2001, Month.JANUARY, 1) }
    val LOCAL_DATE_TIME: LocalDateTime by lazy { LOCAL_DATE.atTime(1, 1) }
    val INSTANT: Instant by lazy { LOCAL_DATE_TIME.toInstant(ZoneOffset.UTC) }
}
