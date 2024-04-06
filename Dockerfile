FROM openjdk:17-jdk-alpine

WORKDIR usr/src/app

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD zbzjxhsdntmd!
ENV MYSQL_HOST kukerton.cby66g86ol5m.ap-northeast-2.rds.amazonaws.com
ENV MYSQL_DATABASE kukerton
ENV MYSQL_PORT 3306
ENV DOCKER_USERNAME dkwkghkdlxld2

ENTRYPOINT ["java", "-jar", "app.jar"]