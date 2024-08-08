FROM  maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/taskservice-0.0.1-SNAPSHOT.jar taskservice.jar
CMD ["java", "-jar", "taskservice.jar"]
EXPOSE 8080