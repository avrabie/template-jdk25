plugins {
    java
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.execodex"
version = "0.0.1-SNAPSHOT"
description = "demo25"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    testImplementation("org.springframework.security:spring-security-test")
    compileOnly("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    // adding a spring security
    implementation("org.springframework.boot:spring-boot-starter-security")

    //add liquibase
    implementation("org.liquibase:liquibase-core")
    //add mapstruct
//    implementation("org.mapstruct:mapstruct")

//    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    runtimeOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
