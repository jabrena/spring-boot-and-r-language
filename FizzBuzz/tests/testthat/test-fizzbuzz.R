test_that("it returns 'Fizz' when a multiple of 3 is given", {
  expect_equal(fizzbuzz(3), "Fizz")
})

test_that("it returns 'Buzz' when a multiple of 5 is given", {
  expect_equal(fizzbuzz(5), "Buzz")
})

test_that("it returns the number when it is not a multiple of 3 or 5", {
  expect_equal(fizzbuzz(4), 4)
})

test_that("it returns 'FizzBuzz' when a multiple of 3 and 5 is given", {
  expect_equal(fizzbuzz(15), "FizzBuzz")
})
