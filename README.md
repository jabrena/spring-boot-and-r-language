# one-api-for-a-r-server

[![](https://gitpod.io/button/open-in-gitpod.svg)](https://github.com/jabrena/one-api-for-a-r-server)

## Motivation

Learn how to use **R** in order to interact with **Java**.

## How to run the project from Spring Boot

```bash
docker compose build
mvn spring-boot:run

curl "http://localhost:8080/"
```

## How to run the project from Docker compose

```bash
docker compose up -d

curl "http://localhost:3000/"
curl "http://localhost:3000/echo"
curl "http://localhost:3000/echo?msg=hello"
curl "http://localhost:3000/plot"
curl "http://localhost:3000/sum" -H "Content-Type: application/json" --data '{"a":4, "b":5}' 

docker compose down
```

## References

- https://www.r-project.org/
- https://r-graph-gallery.com/
- https://www.rplumber.io/
- https://github.com/rstudio/cheatsheets/blob/main/plumber.pdf
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.docker-compose