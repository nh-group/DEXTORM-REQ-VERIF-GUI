from eclipse-temurin:18-jre-alpine
RUN mkdir -p /opt/dextorm/
COPY target/dextorm-gui-1.0.0-SNAPSHOT.war /opt/dextorm/dextorm.war
WORKDIR /opt/dextorm
CMD ["java","-jar","dextorm.war"]
