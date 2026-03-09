import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("com.diffplug.spotless")
    id("io.spring.dependency-management")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

val libs = the<LibrariesForLibs>()

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${libs.versions.spring.boot.get()}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${libs.versions.spring.cloud.get()}")
        mavenBom("org.springframework.modulith:spring-modulith-bom:${libs.versions.spring.modulith.get()}")
    }
    dependencies {
        dependency("org.mockito.kotlin:mockito-kotlin:${libs.versions.mockito.kotlin.get()}")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
    json {
        target("src/**/*.json")
        jackson()
    }
    kotlin {
        ktlint()
    }
    kotlinGradle {
        ktlint()
    }
    yaml {
        target("src/**/*.yml")
        jackson()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}