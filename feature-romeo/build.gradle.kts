plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation(project(":infra-redis"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    testImplementation(testFixtures(project(":infra-redis")))

    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin")
}
