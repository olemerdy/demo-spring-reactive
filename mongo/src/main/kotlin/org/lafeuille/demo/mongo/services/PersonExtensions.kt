package org.lafeuille.demo.mongo.services

import org.lafeuille.demo.mongo.data.Person
import org.lafeuille.demo.mongo.domain.PersonResponse

internal fun Person.toResponse() =
    PersonResponse(
        id = this.id,
        name = this.name,
        birthDate = this.birthDate
    )