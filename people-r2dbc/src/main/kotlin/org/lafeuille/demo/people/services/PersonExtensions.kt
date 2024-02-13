package org.lafeuille.demo.people.services

import org.lafeuille.demo.people.data.Person
import org.lafeuille.demo.people.domain.PersonResponse

internal fun Person.toResponse() =
    PersonResponse(
        id = this.id,
        name = this.name,
        birthDate = this.birthDate,
    )
