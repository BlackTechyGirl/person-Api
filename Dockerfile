# Use the official OpenJDK base image with a specific version
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your local machine into the container
COPY target/person-Api.jar /app/app.jar

# Expose the port your Spring Boot application will listen on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
