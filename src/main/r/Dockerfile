FROM rocker/r-ver:4.3.2
COPY . /app/
WORKDIR /app
RUN R -e "install.packages('remotes'); \
          install.packages('ggplot2'); \
          install.packages('xtable'); \
          install.packages('plumber');"
EXPOSE 3000
CMD ["R", "-e", "r <- plumber::plumb()$run(host = '0.0.0.0', port = 3000)"]