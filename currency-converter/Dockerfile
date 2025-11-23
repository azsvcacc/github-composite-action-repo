# # Use Java 21 runtime image
# FROM eclipse-temurin:21-jdk

# # Set working directory inside container
# WORKDIR /app

# # Copy jar file from target folder into container
# COPY target/currency-converter-0.0.1-SNAPSHOT.jar app.jar

# # Expose the port (same as Spring Boot port)
# EXPOSE 8080

# # Run the jar
# ENTRYPOINT ["java", "-jar", "app.jar"]
# ========== STAGE 1: BUILD ==========
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy only pom.xml to download dependencies first
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Download dependencies (layer caching benefit)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build application
RUN mvn clean package -DskipTests

# ========== STAGE 2: FINAL IMAGE ==========
FROM eclipse-temurin:17-jdk-alpine

# Set workdir
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (change if needed)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
