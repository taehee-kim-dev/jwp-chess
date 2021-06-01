FROM openjdk:8-jdk-alpine
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} ./app.jar
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=local","/app.jar"]