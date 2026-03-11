FROM amazoncorretto:17-al2023-headless
ARG JAR_FILE=build/libs/cloudArchi-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
