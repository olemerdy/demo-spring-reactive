plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))

    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")

    testImplementation("org.springframework.boot:spring-boot-starter-data-elasticsearch-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    testFixturesApi("org.springframework.boot:spring-boot-starter-test")
    testFixturesApi("org.springframework.boot:spring-boot-testcontainers")
    testFixturesApi("org.testcontainers:testcontainers-junit-jupiter")
    testFixturesApi("org.testcontainers:testcontainers-elasticsearch")
}
