package org.lafeuille.demo.mongo.services

import org.lafeuille.demo.mongo.data.Person
import org.lafeuille.demo.mongo.domain.PersonResponse

internal fun responseFromPerson(person: Person): PersonResponse {
    return PersonResponse(
        id = person.id,
        name = person.name,
        birthDate = person.birthDate
    )
}