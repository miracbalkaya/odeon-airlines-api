FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} odeon-airlines.jar

ENTRYPOINT ["java", "-jar", "/odeon-airlines.jar"]

