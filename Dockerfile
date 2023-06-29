FROM eclipse-temurin:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
# docker run -p 8080:8080 --env-file .env <image>
ENTRYPOINT ["java", "-Djdk.tls.client.protocols=TLSv1.2", "-jar", "/app.jar"]
