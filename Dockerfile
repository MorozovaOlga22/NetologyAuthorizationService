FROM classmethod/openjdk-alpine-git

EXPOSE 8080

WORKDIR appDir

ADD target/authorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]