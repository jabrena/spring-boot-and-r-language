# read methods

In R, there are several ways to load data. Here are some common methods:

read.csv() / read.csv2(): These functions are used to read comma-separated values files. read.csv() is used for files with commas as separators, while read.csv2() is used for files with semicolons as separators (commonly used in some European countries).

read.table(): This function is more generic and can be used to read various types of tabular data.

read.delim() / read.delim2(): Similar to read.csv() and read.csv2(), these functions are used to read tab-delimited files, with read.delim() using tabs as separators and read.delim2() using semicolons.

read.xlsx(): This function is part of the readxl package and is used to read Microsoft Excel files.

readRDS(): This function is used to read datasets saved in the RDS (R Data Serialization) format.

readLines(): This function is used to read lines from a text file.

fread(): This function from the data.table package is a fast and efficient way to read delimited files, especially large ones.

readr package functions: The readr package provides several functions such as read_csv(), read_tsv(), and read_table() which offer faster and more user-friendly alternatives to base R functions for reading delimited files.

DBI package functions: If your data is stored in a database, you can use functions from the DBI package, such as dbConnect() and dbReadTable(), to connect to the database and read data directly into R.

# References

- https://www.rdocumentation.org/packages/utils/versions/3.6.2/topics/read.table