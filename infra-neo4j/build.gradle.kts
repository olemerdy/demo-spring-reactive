plugins {
    `project-kotlin-module`
    `java-test-fixtures`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
}