FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/library-rest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_library-rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_library-rest.jar"]