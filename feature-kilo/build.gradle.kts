plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation(project(":infra-kafka"))

    testImplementation(testFixtures(project(":infra-kafka")))
}
