from maven:3.8-openjdk-11-slim
RUN mkdir -p /opt/dextorm-output
RUN apt update && apt install -y libatomic1 && rm -rf /var/lib/apt/lists/*
COPY pom.xml /opt/dextorm/pom.xml
COPY src/ /opt/dextorm/src/
COPY ./docker/builder.sh /opt/dextorm
WORKDIR /opt/dextorm
CMD ["sh","builder.sh"]
