# Use Eclipse Temurin (official OpenJDK distribution)
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy jar file from target folder
COPY target/bidding-app-1.0.jar app.jar

# Expose port (optional if using web app)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]