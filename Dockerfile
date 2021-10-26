FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD target/nps.war nps.war
ENTRYPOINT ["java","-jar","/nps.war"]