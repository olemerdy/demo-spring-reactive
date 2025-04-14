plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$embeddedKotlinVersion")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:7.0.3")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.52.0")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
}
