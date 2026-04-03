package org.lafeuille.demo.mike.domain

import org.lafeuille.demo.mike.data.Mike
import org.springframework.data.geo.Point
import java.time.Duration
import java.time.Period
import java.util.Currency
import java.util.Locale
import java.util.UUID

object MikeFixtures {
    const val ID_STRING = "ed41a7d0-1f7e-4f92-a91f-b6fe99384f3f"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val NAME = "Mickey"
    val LOCALE: Locale by lazy { Locale.FRANCE }
    val CURRENCY: Currency by lazy { Currency.getInstance(LOCALE) }

    val DURATION: Duration by lazy { Duration.ofDays(1).plusHours(6).plusMinutes(30) }
    val PERIOD: Period by lazy { Period.ofYears(1).plusMonths(2).plusDays(3) }

    const val LOCATION_X: Double = 123.0
    const val LOCATION_Y: Double = 456.0
    val LOCATION: Point by lazy { Point(LOCATION_X, LOCATION_Y) }

    fun defaultMike() =
        Mike(
            id = ID,
            name = NAME,
            locale = LOCALE,
            currency = CURRENCY,
            duration = DURATION,
            period = PERIOD,
            location = LOCATION,
        )

    fun defaultMikeResponse() = MikeResponse(id = ID, name = NAME, location = LOCATION)
}
