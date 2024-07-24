# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/burdget-management-0.0.1-SNAPSHOT.jar /app/burdget-management.jar

# Make port 9000 available to the world outside this container
EXPOSE 9000

# Run the JAR file
ENTRYPOINT ["java", "-jar", "burdget-management.jar"]
