FROM openjdk:17

COPY target/ticket-0.0.1-SNAPSHOT.jar ticket-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ticket-0.0.1-SNAPSHOT.jar"]