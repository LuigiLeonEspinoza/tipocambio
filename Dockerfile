FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER retobackend
RUN addgroup -S spring && adduser -S spring -S spring
USER spring:spring
COPY "./target/tipocambio-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]