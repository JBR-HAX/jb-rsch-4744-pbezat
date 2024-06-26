plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("com.google.code.gson:gson:2.9.1")
    implementation ("org.hsqldb:hsqldb:2.6.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("com.vladmihalcea:hibernate-types-52:2.10.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    //add dependencies as needed
}

tasks.withType<Test> {
    useJUnitPlatform()
}
