plugins {
    `project-kotlin-module`
}

dependencies {
    implementation(project(":infra-shared"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
}