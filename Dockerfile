FROM ubuntu:latest

EXPOSE 8080

RUN mkdir app

WORKDIR /app

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    apt-get install -y ant && \
    apt-get clean

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml pom.xml
COPY src src

RUN cd /app && \
    ls -al

RUN ./mvnw clean install

ENTRYPOINT ["java", "-jar", "target/testapp-0.0.1-SNAPSHOT.jar"]