FROM openjdk:8
ADD target/footballmarket.jar footballmarket.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","footballmarket.jar"]