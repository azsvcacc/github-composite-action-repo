# Use Java 21 runtime image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy jar file from target folder into container
COPY target/currency-converter-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (same as Spring Boot port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
