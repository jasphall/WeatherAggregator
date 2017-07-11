FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Maciej Sikorski
EXPOSE 5432
COPY weatheraggregator-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]
