FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./target/weappdemo.jar weappdemo.jar
ENTRYPOINT ["java","-jar","/weappdemo.jar", "&"]
