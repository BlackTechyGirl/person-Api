# Use the official OpenJDK base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/person-Api-0.0.1-SNAPSHOT.jar .

# Expose the port your application listens on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "person-Api-0.0.1-SNAPSHOT.jar"]
