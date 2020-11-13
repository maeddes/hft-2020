FROM openjdk:8-alpine
RUN mkdir -p /opt/hello
WORKDIR /opt/hello
COPY target/hello-world-new-0.0.1-SNAPSHOT.jar /opt/hello
CMD ["java", "-jar", "hello-world-new-0.0.1-SNAPSHOT.jar"]