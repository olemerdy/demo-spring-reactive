plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    testImplementation(project(":infra-postgresql"))
    testImplementation(testFixtures(project(":infra-postgresql")))

    testImplementation("org.springframework.boot:spring-boot-starter-data-r2dbc-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    testRuntimeOnly("org.postgresql:r2dbc-postgresql")

    testFixturesApi("org.testcontainers:testcontainers-r2dbc")
}
