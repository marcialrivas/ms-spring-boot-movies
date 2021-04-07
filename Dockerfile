FROM openjdk:11-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY filebeat.yml /filebeat.yml
RUN set -x && \
      apt-get update && \
      apt-get install -y wget && \
      wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.12.0-linux-x86_64.tar.gz -O /opt/filebeat.tar.gz && \
      cd /opt && \
      tar xzvf filebeat.tar.gz && \
      cd filebeat-* && \
      cp filebeat /bin && \
      cd /opt && \
      rm -rf filebeat* && \
      apt-get purge -y wget && \
      apt-get autoremove -y && \
      apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
ENTRYPOINT ["/bin/sh", "-c" , "nohup filebeat -e & java -jar /app.jar"]
EXPOSE 8080