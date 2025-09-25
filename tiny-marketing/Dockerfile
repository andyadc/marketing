# Use a base image with OpenJDK 11
FROM openjdk:11-jre-slim

MAINTAINER andyadc

# Set the working directory inside the container
WORKDIR /app

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Copy the compiled JAR file into the container
ADD target/tiny-marketing.jar /tiny-marketing.jar
COPY target/tiny-marketing.jar /app/tiny-marketing.jar

# Expose the port your application listens on (if applicable)
# Replace '8080' with the actual port
EXPOSE 8080

# Define the command to run your application when the container starts
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /tiny-marketing.jar $PARAMS"]

