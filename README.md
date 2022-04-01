# SpringBoardPortfolio
SpringBoot + Spring Data JPA + MariaDB

**
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
