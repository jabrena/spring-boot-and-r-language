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

#* Hello World
#* @get /
function() {
  return("Hello World")
}

#* Echo back the input
#* @param msg The message to echo
#* @get /echo
function(msg="") {
  list(msg = paste0("The message is: '", msg, "'"))
}

#* Plot a histogram
#* @serializer png
#* @get /plot
function() {
  rand <- rnorm(100)
  hist(rand)
}

#* Return the sum of two numbers
#* @param a The first number to add
#* @param b The second number to add
#* @post /sum
function(a, b) {
  as.numeric(a) + as.numeric(b)
}
