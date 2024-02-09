FROM rocker/r-ver:4.3.2
COPY . /app/
WORKDIR /app
RUN R -e "install.packages('remotes'); \
          remotes::install_deps('FizzBuzz', dependencies = TRUE); \
          remotes::install_local('FizzBuzz');"
RUN R CMD check FizzBuzz --no-manual
EXPOSE 3000
CMD ["R", "-e", "r <- plumber::plumb()$run(host = '0.0.0.0', port = 3000)"]