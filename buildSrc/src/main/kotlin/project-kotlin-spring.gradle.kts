plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.3.2"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.3"))

    constraints {
        testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
        testImplementation("org.junit.jupiter:junit-jupiter")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }
}
