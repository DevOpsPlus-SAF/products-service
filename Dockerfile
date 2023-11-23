FROM amazoncorretto:17

LABEL authors="leona"

RUN mkdir -p /home/ksero
COPY /target/products-microservice-0.0.1-SNAPSHOT.jar /home/ksero

EXPOSE 8100

CMD ["java", "-jar", "/home/ksero/products-microservice-0.0.1-SNAPSHOT.jar"]