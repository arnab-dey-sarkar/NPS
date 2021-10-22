FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD target/nps.jar nps.jar
ENTRYPOINT ["java","-jar","/nps.jar"]