#running base image
FROM openjdk:8-jdk-alpine

#documentation
LABEL "MAINTAINER" "Rama Bhakt KANISHK BHATT"

#documentation
EXPOSE 5000

#cleaning up
RUN rm -rf /tmp/*

#copying latest jar
COPY ./target/*.jar /tmp/app.jar

#DO not want folks to run it command while running
#they can do while docker container exec commadn to get into container
ENTRYPOINT ["java","-jar","/tmp/app.jar"]
