# Etapa de construcción
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución con Amazon Corretto
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app_bazar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_bazar.jar"]