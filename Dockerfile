FROM openjdk:8-alpine as build

WORKDIR /opt
COPY . .
RUN ./gradlew clean build

FROM openjdk:8-alpine as release
WORKDIR /opt
COPY --from=build /opt/build/libs/helloworld-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
