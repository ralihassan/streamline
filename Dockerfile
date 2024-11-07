FROM openjdk:21
COPY target/streamline-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]