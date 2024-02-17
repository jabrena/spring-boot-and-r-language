# ggplot2

> “The simple graph has brought more information to the data analyst’s mind than
any other device.” — John Tukey

Every graph can be described as a combination of independent building blocks:

- data: a data frame: quantitative, categorical; local or data base query
- aesthetic mapping of variables into visual properties: size, color, x, y
- geometric objects (“geom”): points, lines, areas, arrows, …
- coordinate system (“coord”): Cartesian, log, polar, map, 

## References

- https://www.tidyverse.org/
- https://exts.ggplot2.tidyverse.org/
- https://www.tutorialspoint.com/ggplot2/ggplot2_tutorial.pdf
- https://www.rdocumentation.org/packages/ggplot2/versions/3.4.4
- https://r-graphics.org/chapter-ggplot2
- http://zevross.com/blog/2014/08/04/beautiful-plotting-in-r-a-ggplot2-cheatsheet-3/

## Books

- https://rc2e.com/
- https://ggplot2-book.org/
- http://www.cookbook-r.com/Graphs/


## WIP

- https://bookdown.org/ggiaever/r4ds-solutions/r4ds-ggplot2.pdf

## Done

- https://web.stanford.edu/~lstell/ggplot2Intro.pdf
- https://www.datavis.ca/courses/RGraphics/R-Graphics4.pdf

## Log

```
library("ggplot2")
help(ggplot2)
data(iris)

ggplot(data = mpg) + geom_point(mapping = aes(x = displ, y = hwy))
nrow(mpg)
nrow(unique(mpg[ , c("displ","hwy") ]))
ggplot(data = mpg) + geom_jitter(mapping = aes(x = displ, y = hwy))
ggplot(data = mpg) + geom_jitter(mapping = aes(x = displ, y = hwy), color="orange") # Outside aes()
ggplot(mpg) + geom_jitter(aes(x = displ, y = hwy, color = drv)) # Inside aes()
class(mpg$year)
table(mpg$year)
mpg.mod <- transform(mpg, year = as.factor(year))
class(mpg.mod$year)
ggplot(mpg.mod) + geom_jitter(aes(x = displ, y = hwy, color = drv, shape = year))
ggplot(mpg.mod, aes(x = displ, y = hwy)) + geom_jitter(aes(group = drv, color = drv, shape = year)) + geom_smooth(method = "loess", color = "black")

h.basic <- ggplot(mpg.mod,
aes(x = displ, y = hwy,
color = drv, group = drv,
shape = year)) +
geom_jitter()
h.basic + geom_smooth(method="loess")

library("plyr")
tmp <- cbind(ddply(mpg, .(drv), nrow),
displ = c(2.2, 3, 6), hwy = c(15, 35, 31))
ggplot(mpg.mod,
aes(x = displ, y = hwy, color = drv, group = drv)) +
geom_jitter(aes(shape = year)) +
geom_label(data = tmp, aes(label = V1), show.legend = F)

h.basic + facet_wrap(vars(cyl))

lbl.cyl <- paste(unique(mpg.mod$cyl), "cylinders")
names(lbl.cyl) <- unique(mpg.mod$cyl) # REQUIRED
h.basic +
facet_wrap(vars(cyl), nrow = 1,
labeller = as_labeller(lbl.cyl))

mtcars$cyl <- as.factor(mtcars$cyl)
plot(mpg ~ hp , data=mtcars,
 col=cyl, pch=c(4,6,8)[mtcars$cyl], cex=1.2)
legend("topright", legend=levels(mtcars$cyl),
 pch = c(4,6,8),
 col=levels(mtcars$cyl))

library(ggplot2)
ggplot(mtcars, aes(x=hp, y=mpg, color=cyl, shape=cyl)) +
 geom_point(size=3)

ggplot(mtcars, aes(x=hp, y=mpg, color=cyl, shape=cyl)) +
 geom_point(size=3) +
 geom_smooth(method="lm", aes(fill=cyl)) 

ggplot(mtcars, aes(x=hp, y=mpg)) +
 geom_point(size=3, aes(color=cyl, shape=cyl)) +
 geom_smooth(method="lm", aes(color=cyl, fill=cyl)) +
 geom_smooth(method="loess", color="black", se=FALSE)

last_plot() + theme_bw()

plt <-
ggplot(mtcars, aes(x=hp, y=mpg, color=cyl, shape=cyl)) +
geom_point(size=3) +
geom_smooth(method="lm", aes(fill=cyl))
plt + facet_wrap(~cyl)

plt2 <- ggplot(mtcars, aes(x=wt, y=mpg)) +
 geom_point(color = 'red', size=2) +
 geom_smooth(method="loess") +
 labs(y="Miles per gallon", x="Weight (1000 lbs.)") +
 theme_classic(base_size = 16)
plt2 + geom_text(aes(label = rownames(mtcars)))

install.packages(“ggrepel”)
library(ggrepel)
plt2 +
 geom_text_repel(aes(label = rownames(mtcars)))

mod <- loess( mpg ~ wt, data=mtcars)
resids <- residuals(mod)
mtcars$label <- ifelse(abs(resids) > 2.5,
 rownames(mtcars), "")
plt2 + geom_text_repel(aes(label = mtcars$label))

names(plt)
class(plt)

library(gridExtra)
```