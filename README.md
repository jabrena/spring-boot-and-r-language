# Spring Boot & R Stat Server

[![](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/jabrena/spring-boot-and-r)

## Motivation

A repository to explore how to interact with **R** from **Java** with **Spring Boot**.

## How to run the project from Spring Boot

```bash
docker compose build
./mvnw spring-boot:run

curl "http://localhost:8080/"
```

## How to run the project from Docker compose

```bash
docker compose build
docker compose up -d

curl "http://localhost:3000/"
curl "http://localhost:3000/echo"
curl "http://localhost:3000/echo?msg=hello"
curl "http://localhost:3000/plot"
curl "http://localhost:3000/sum" -H "Content-Type: application/json" --data '{"a":4, "b":5}' 

#Swagger from Plumber
open http://localhost:3000/__docs__/

docker compose down
```

## References

- https://www.r-project.org/
- https://r-graph-gallery.com/
- https://rocker-project.org/
- https://ggplot2.tidyverse.org/
- https://github.com/rstudio
- https://github.com/rstudio/cheatsheets/blob/main/base-r.pdf
- https://github.com/rstudio/cheatsheets/blob/main/data-visualization.pdf
- https://github.com/rstudio/cheatsheets/blob/main/time-series.pdf
- https://github.com/rstudio/cheatsheets/blob/main/plumber.pdf
- https://www.rplumber.io/
- https://spring.io/projects/spring-boot
- https://hypermedia.systems/book/contents/
- https://stat.ethz.ch/pipermail/r-help/2006-June/107869.html

Made with ❤️ from Madrid