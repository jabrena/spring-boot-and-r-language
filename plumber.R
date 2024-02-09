# plumber.R

library(FizzBuzz)

#* @post /
function(req, res) {
  # parse the JSON string from the post body
  data <- jsonlite::fromJSON(req$postBody)

  number <- data$number

  output <- fizzbuzz(number)

  res$body <- jsonlite::toJSON(
    list(
      result = output
    ), auto_unbox = TRUE
  )

  return(res)
}
