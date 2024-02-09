# one-api-for-a-r-server

[![](https://gitpod.io/button/open-in-gitpod.svg)](https://github.com/jabrena/one-api-for-a-r-server)

## Motivation

Learn how to use **R** in order to interact with **Java**.

## How to build the project

```bash
docker compose build
docker compose up -d
newman run --global-var host=localhost:3000 ./postman/fizzbuzz.postman_collection.json 
docker compose down
```

## References

- https://cloudnative.ly/building-a-rest-api-in-r-with-tdd-docker-and-ci-cd-part-2-3-2a3f951ee59f
- https://dev.azure.com/nagyben/_git/fizzbuzz
- https://learning.postman.com/docs/collections/using-newman-cli/command-line-integration-with-newman/