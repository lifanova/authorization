FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ADD build/libs/authorization-0.0.1-SNAPSHOT.jar app_docker.jar

ENTRYPOINT ["java", "-jar", "/app_docker.jar"]
