![maven](https://github.com/fcobello/aluraflix/workflows/maven/badge.svg)
![docker](https://img.shields.io/badge/docker-powered-blue)
![license](https://img.shields.io/github/license/fcobello/aluraflix)

# aluraflix

Aplicação construida para Challenge do [Alura Backend](https://www.alura.com.br/challenges/back-end/)

## Pré requisitos
Java 11 (https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Maven (https://maven.apache.org/download.cgi)

Executar os comandos na raiz do projeto

## Documentação
Está disponivel na pasta docs a documentação estatica da API ou acesse pelo [Link](https://htmlpreview.github.io/?https://github.com/fcobello/aluraflix/blob/master/docs/api.html)

## Como Compilar

`mvn clean install`

## Como executar (Maven)

`mvn spring-boot:run`

## Como executar (Docker)

`docker build -t fcobello/aluraflix .`

`docker run -p 8080:8080 fcobello/aluraflix`

## Como testar (Postman)

Importar a [Collection](https://github.com/fcobello/itau-test/blob/master/itau.postman_collection) disponivel na raiz do projeto no [Postman](https://postman.com)

## Como acessar o banco de dados
Para esse projeto foi utilizado o banco H2 em memoria, o banco é recriado a cada start da aplicação

É possivel acessar o banco através de uma WebConsole (http://localhost:8080/h2-console), os dados de usuario, senha e url podem ser obtidos no arquivo application.properties