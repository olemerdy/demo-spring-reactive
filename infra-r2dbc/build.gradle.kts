plugins {
    `project-kotlin-jvm`
    embeddedKotlin("plugin.spring")
    alias(libs.plugins.spring.boot).apply(false)
    alias(libs.plugins.spring.dependencies.management)
}

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

    implementation(project(":shared"))

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
}
