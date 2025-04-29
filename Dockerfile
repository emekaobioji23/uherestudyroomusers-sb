# Use OpenJDK 17 base image
FROM eclipse-temurin:17-jdk

# Copy the built jar from target/
COPY target/*.jar app.jar

# Expose the default port Spring Boot uses
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

