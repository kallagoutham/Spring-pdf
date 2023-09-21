FROM openjdk:11 AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/file-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
