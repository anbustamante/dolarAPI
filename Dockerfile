FROM amazoncorretto:21-alpine-jdk

COPY ./10-dolarapi2/build/libs/dolarhoy-0.0.1-SNAPSHOT.jar /app/dolarhoy-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/auna-0.0.1-SNAPSHOT.jar"]
