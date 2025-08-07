FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY ./bazar /app
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar appbazar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "appbazar.jar"]