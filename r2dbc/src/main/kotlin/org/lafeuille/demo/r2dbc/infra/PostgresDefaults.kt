package org.lafeuille.demo.r2dbc.infra

object PostgresDefaults {
    const val VERSION = "15"
    const val DOCKER_IMAGE_NAME = "postgres:$VERSION"
}