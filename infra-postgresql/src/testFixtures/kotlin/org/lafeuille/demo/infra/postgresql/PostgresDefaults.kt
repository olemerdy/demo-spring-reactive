package org.lafeuille.demo.infra.postgresql

// see https://github.com/spring-projects/spring-boot/issues/40325
object PostgresDefaults {
    private const val VERSION = "16"
    const val DOCKER_IMAGE_NAME = "postgres:$VERSION"
}