plugins {
    `project-kotlin-jvm`
    `project-kotlin-spring`
}

dependencies {
    implementation(project(":shared"))

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
}
