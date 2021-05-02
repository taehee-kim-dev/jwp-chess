FROM openjdk:8-jdk-alpine
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} ./app.jar
COPY /db-config/application-deploy-db.properties /db-config/application-deploy-db.properties
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.additional-location=file:/db-config/application-deploy-db.properties","/app.jar"]