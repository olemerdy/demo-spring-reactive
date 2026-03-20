plugins {
    `project-kotlin-module`
    alias(libs.plugins.gorylenko.git.properties)
    alias(libs.plugins.spring.boot)
    id("maven-publish")
}

dependencies {
    implementation(project(":infra-shared"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // implementation("org.springframework.boot:spring-boot-starter-data-cassandra-reactive")
    // implementation("org.springframework.boot:spring-boot-starter-data-couchbase-reactive")
    // implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    // implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    // implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
    // implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    // implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    // implementation("org.springframework.boot:spring-boot-starter-flyway")
    // implementation("org.springframework.boot:spring-boot-starter-validation")
    // implementation("org.springframework.boot:spring-boot-starter-webclient")
    // implementation("org.springframework.boot:spring-boot-starter-webflux")
    // implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    // implementation("org.springframework:spring-jdbc")
    // implementation("org.springframework.modulith:spring-modulith-events-api")
    // implementation("org.springframework.modulith:spring-modulith-starter-core")
    // implementation("org.springframework.modulith:spring-modulith-starter-neo4j")
    // implementation("tools.jackson.module:jackson-module-kotlin")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    // runtimeOnly("org.springframework.modulith:spring-modulith-events-amqp")
    // runtimeOnly("org.springframework.modulith:spring-modulith-observability")

    testImplementation(testFixtures(project(":infra-mongodb")))
    // testImplementation("org.springframework.boot:spring-boot-starter-actuator-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-amqp-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-cassandra-reactive-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-couchbase-reactive-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-elasticsearch-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-neo4j-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-r2dbc-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-data-redis-reactive-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-webclient-test")
    // testImplementation("org.springframework.boot:spring-boot-starter-webflux-test")
    // testImplementation("org.springframework.boot:spring-boot-testcontainers")
    // testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    // testImplementation("org.testcontainers:testcontainers-cassandra")
    // testImplementation("org.testcontainers:testcontainers-couchbase")
    // testImplementation("org.testcontainers:testcontainers-elasticsearch")
    // testImplementation("org.testcontainers:testcontainers-junit-jupiter")
    // testImplementation("org.testcontainers:testcontainers-mongodb")
    // testImplementation("org.testcontainers:testcontainers-neo4j")
    // testImplementation("org.testcontainers:testcontainers-r2dbc")
    // testImplementation("org.testcontainers:testcontainers-rabbitmq")
}

publishing {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/olemerdy/demo-spring-reactive")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("bootJar") {
            artifact(tasks.named("bootJar"))
        }
    }
}

gitProperties {
    dotGitDirectory =
        project.rootProject.layout.projectDirectory
            .dir(".git")
}

springBoot {
    mainClass = "org.lafeuille.demo.ApplicationKt"
    buildInfo()
}

// tasks.named<BootBuildImage>("bootBuildImage") {
//    imageName.set("gchr.io/olemerdy/${rootProject.name}:${project.version}")
//    docker {
//        publishRegistry {
//            username = System.getenv("USERNAME")
//            password = System.getenv("TOKEN")
//        }
//    }
// }
