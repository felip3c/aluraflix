FROM adoptopenjdk/openjdk11:alpine-slim
LABEL Felipe Cobello
WORKDIR /opt/app
ADD  /target/aluraflix.jar  ./
ENTRYPOINT java -jar aluraflix.jar