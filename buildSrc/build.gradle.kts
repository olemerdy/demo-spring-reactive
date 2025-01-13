plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$embeddedKotlinVersion")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:7.0.1")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
}
