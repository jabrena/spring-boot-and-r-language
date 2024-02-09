# one-api-for-a-r-server

[![](https://gitpod.io/button/open-in-gitpod.svg)](https://github.com/jabrena/one-api-for-a-r-server)

## Motivation

Learn how to use **R** in order to interact with **Java**.

## How to build the project

```bash
docker compose build
mvn spring-boot:run
docker compose up -d
newman run --color=auto --verbose -r cli,junit --global-var host=localhost:3000 ./postman/fizzbuzz.postman_collection.json 

curl "http://localhost:3000/"
curl "http://localhost:3000/echo"
curl "http://localhost:3000/echo?msg=hello"
curl "http://localhost:3000/plot"
curl "http://localhost:3000/sum" -H "Content-Type: application/json" --data '{"a":4, "b":5}' 

docker compose down
```

## References

- https://www.rplumber.io/
- https://github.com/rstudio/cheatsheets/blob/main/plumber.pdf
- https://cloudnative.ly/building-a-rest-api-in-r-with-tdd-docker-and-ci-cd-part-2-3-2a3f951ee59f
- https://dev.azure.com/nagyben/_git/fizzbuzz
- https://learning.postman.com/docs/collections/using-newman-cli/command-line-integration-with-newman/
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.docker-compose