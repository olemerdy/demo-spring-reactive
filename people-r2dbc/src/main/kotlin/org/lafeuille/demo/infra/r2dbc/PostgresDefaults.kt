package org.lafeuille.demo.infra.r2dbc

object PostgresDefaults {
    const val VERSION = "15"
    const val DOCKER_IMAGE_NAME = "postgres:$VERSION"
}