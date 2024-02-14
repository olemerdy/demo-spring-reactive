plugins {
    `project-kotlin-jvm`
    `project-kotlin-spring`
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springframework:spring-webflux")
}
