FROM openjdk:19

COPY target/Agenda-1.0.0.jar /agendaapp.jar

CMD ["java", "-jar", "/agendaapp.jar"]