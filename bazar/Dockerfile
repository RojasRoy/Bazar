FROM amazoncorretto:17-alpine-jdk

COPY target/bazar-0.0.1-SNAPSHOT.jar /app_bazar.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app_bazar.jar"]