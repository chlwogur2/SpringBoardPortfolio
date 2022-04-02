# SpringBoardPortfolio
SpringBoot + Spring Data JPA + MariaDB + Bootstrap


***application.yml***
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/portfolio?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false
    driver-class-name: org.mariadb.jdbc.Driver
    username: root
    password: *********
  jpa:
    defer-datasource-initialization: true
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        format_sql: true #To beautify or pretty print the SQL
        show_sql: true #show sql


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
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0'
	implementation group: 'org.mariadb.jdbc', name: 'mariadb-java-client', version: '2.7.3'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'mysql:mysql-connector-java:8.0.25'
	runtimeOnly 'mysql:mysql-connector-java'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'	// MariaDB
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}

```
