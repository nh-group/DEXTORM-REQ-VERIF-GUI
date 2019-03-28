from openjdk
COPY target/req-web-1.0.0-SNAPSHOT.war /root/gui.war
CMD java -jar /root/gui.war