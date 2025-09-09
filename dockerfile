# Use a lean OpenJDK image for the build stage
FROM openjdk:21-jdk-slim AS build

# Install Maven on top of the OpenJDK image
RUN apt-get update && \
    apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to download dependencies first, to take advantage of Docker caching
COPY pom.xml .

# Copy the rest of the application source code
COPY src ./src

# Build the Spring Boot application
RUN mvn clean install -DskipTests

# Use a lean OpenJDK image for the final stage
FROM openjdk:21-slim

# Set the working directory for the final image
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the application will run
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
