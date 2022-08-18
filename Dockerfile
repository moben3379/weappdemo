
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./target/demojenkins.jar demojenkins.jar
ENTRYPOINT ["java","-jar","/demojenkins.jar", "&"]

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/weappdemo.jar weappdemo.jar
ENTRYPOINT ["java","-jar","/weappdemo.jar", "&"]

