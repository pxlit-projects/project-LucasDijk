FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/comment-service.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app/app.jar"]
