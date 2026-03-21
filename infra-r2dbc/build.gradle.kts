plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    testFixturesApi("org.testcontainers:testcontainers-r2dbc")
}
