plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation(project(":infra-elasticsearch"))

    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    testImplementation(testFixtures(project(":infra-elasticsearch")))

    testImplementation("org.springframework.boot:spring-boot-starter-data-elasticsearch-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("io.projectreactor:reactor-test")
}
