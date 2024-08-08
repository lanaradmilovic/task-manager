#FROM maven:3.8.4-openjdk-11-slim AS build
#WORKDIR /workspace/app
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests
#
#FROM openjdk:11-jre-slim
#COPY --from=build workspace/app/target/userservice-0.0.1-SNAPSHOT.jar userservice.jar
#ENTRYPOINT ["java", "-jar", "/userservice.jar"]
#EXPOSE 8081
#FROM maven:3.8.4-openjdk-11-slim AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#FROM openjdk:11-jre-slim
#WORKDIR /app
#COPY --from=build /app/target/userservice-0.0.1-SNAPSHOT.jar .
#CMD ["java", "-jar", "userservice-0.0.1-SNAPSHOT.jar"]
# Build stage
FROM  maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/userservice-0.0.1-SNAPSHOT.jar userservice.jar
CMD ["java", "-jar", "userservice.jar"]
EXPOSE 8081




