# build container
FROM openjdk:8-jdk-alpine as build
VOLUME /tmp
COPY . .
RUN ./gradlew clean build

# Deployable container
FROM openjdk:8-jdk-alpine
WORKDIR /app
# Copy the *.jar artifact from the build container to this container
COPY --from=build build/libs/*.jar app.jar
ARG JAR_FILE
ENTRYPOINT ["java", "-jar", "app.jar"]
# Expose the port, so that other services can us this container on the docker network
EXPOSE 8080

#docker build -t gmdb/gmdb-movies .
#docker run -d -p8080:8080 --rm gmdb/gmdb-movies