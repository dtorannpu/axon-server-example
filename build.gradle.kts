plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.diffplug.spotless") version "7.0.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.axonframework:axon-spring-boot-starter:4.11.2")
	implementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("org.postgresql:postgresql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

spotless {
	java {
		lineEndings = com.diffplug.spotless.LineEnding.UNIX
		importOrder()
		removeUnusedImports()
		cleanthat()
			.sourceCompatibility("21")
		googleJavaFormat()
		formatAnnotations()
	}
}
