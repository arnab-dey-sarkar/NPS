FROM java:8
EXPOSE 8086
ADD target/nps.war nps.war
ENTRYPOINT ["java","-jar","nps.war"]
