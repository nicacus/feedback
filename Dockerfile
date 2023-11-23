FROM adoptopenjdk/openjdk11
ENV TZ=Europe/Athens
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD app.jar app.jar
ENTRYPOINT ["java","-D","-jar","/app.jar"]