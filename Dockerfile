FROM openjdk:8
ARG WAR_FILE
RUN pwd
COPY ${WAR_FILE} app.war
ENTRYPOINT ["java", "-jar", "/app.war"]