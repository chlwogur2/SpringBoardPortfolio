# SpringBoardPortfolio
SpringBoot + Spring Data JPA + MariaDB + Bootstrap


***application.yml***
```
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/tutorial
    driver-class-name: org.mariadb.jdbc.Driver
    username: root
    password: *************
  jpa:
    open-in-view: false
    generate-ddl: true
    show-sql: true
    hibernate:
      ddl-auto: update

logging.level:
  org.hibernate.type: trace
```

***build.gradle***
```
plugins {
	id 'org.springframework.boot' version '2.6.5'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

group = 'my_portfolio'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.6'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'mysql:mysql-connector-java'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'	// MariaDB
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}

```
