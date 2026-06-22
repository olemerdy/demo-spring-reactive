package org.lafeuille.demo.mike.domain

import org.springframework.data.geo.Point
import java.net.URI
import java.time.Duration
import java.time.Month
import java.time.Period
import java.util.Currency
import java.util.Locale
import java.util.UUID

data class MikeResponse(
    val id: UUID,
    val name: String,
    val locale: Locale,
    val currency: Currency,
    val duration: Duration,
    val period: Period,
    val month: Month,
    val location: Point,
    val uri: URI,
)
