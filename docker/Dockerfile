from openjdk:11-jre
RUN mkdir -p /opt/dextorm/
COPY build/dextorm.war /opt/dextorm/dextorm.war
WORKDIR /opt/dextorm
CMD ["java","-jar","dextorm.war"]
