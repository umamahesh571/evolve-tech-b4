# Evolve Tech

A static Java 21-based Spring Boot web application that presents a DevOps course landing page.

## Features

- Java 21
- Spring Boot (packaged as JAR)
- CI/CD-ready with Jenkins
- SonarQube integration
- 60%+ unit test coverage with JaCoCo

## Build & Run

```bash
mvn clean install
java -jar target/evolve-tech-1.0.0.jar
```

Access: http://localhost:8080

## CI/CD

Use provided `Jenkinsfile`. Configure `jdk21`, `Maven 3`, and a Jenkins credential called `sonar-token`.

---