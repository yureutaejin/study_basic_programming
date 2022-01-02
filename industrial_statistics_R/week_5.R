# vector_basic
name <- c("John", "Jane", "Steve")
temperature <- c(98.1, 98.6, 101.4)
flu_status <- c(FALSE,FALSE,TRUE)

name[2]
name[2:3]
name[1:2]
name[c(TRUE,TRUE,FALSE)]

gender <- c("MALE", "FEMALE", "MALE")

# factor_basic
gender <- factor(c("MALE", "FEMALE", "MALE"))
gender
blood <- factor(c("O", "AB", "A"), levels=c("A", "B", "O", "AB"))
blood

# list_basic
subject1 <- list(name = name[1], temperature = temperature[1], flu_status = flu_status[1])
subject1
subject1[1]
subject1$name
subject1[2]
subject1$temperature

# dataframe_basic
pt_data <-data.frame(name, temperature, flu_status, gender, blood)
pt_data

pt_data$name
pt_data[1, 2]
pt_data[c(1, 3), c(2, 4)]
pt_data[,1]
pt_data[1,1]
pt_data[-2, -3]

# matrix_and_array_basic
m <- matrix(c('a', 'b', 'c', 'd', 'e', 'f'), nrow=2)
m
m <- matrix(c('a', 'b', 'c', 'd', 'e', 'f'), ncol=2)
m

# basic_data_analysis

## data import
usedcars <- read.csv("/Users/jinyuntae/Desktop/programming/industrial_statistics_R/data/usedcars.csv", stringsAsFactors = FALSE)
usedcars

## 요약
str(usedcars) # .info()
summary(usedcars) # .describe()
summary(usedcars$model)
summary(usedcars[c("price", 'mileage')])

## basic_statistics
mean(usedcars$price)
var(usedcars$price)
sd(usedcars$price)
median(usedcars$price)
summary(usedcars$price)
range(usedcars$price) # min max
diff(range(usedcars$price)) # 차이 출력
IQR(usedcars$price)
quantile(usedcars$price)
quantile(usedcars$price, probs=c(0.05, 0.80, 0.85, 0.98))
quantile(usedcars$price, seq(from=0, to=1, by=0.1))

## graph_visualization
### boxplot
boxplot(usedcars$price)
boxplot(usedcars$mileage)

### hist
hist(usedcars$mileage, main="mileage_hist", xlab= "mileage")

### scatterplot
plot(usedcars$mileage, usedcars$price)
plot(usedcars$mileage, usedcars$price, main = "Scatterplot",
     xlab = "mileage", ylab = "price")

## categorical variable
table(usedcars$model)

usedcars$model <- factor(usedcars$model)
usedcars$color <- factor(usedcars$color)
usedcars$transmission <- factor(usedcars$transmission)
str(usedcars)

color_table <- prop.table(table(usedcars$color))
round(color_table)
round(color_table, digits = 1)
round(color_table, digits = 2)
round(color_table, digits = 4)

## crosstable
library(gmodels)

CrossTable(usedcars$model, usedcars$color)

# same with df['conservative] = df['color'].map(color_dictionary or color_to_numeric_func)
usedcars$conservative <- usedcars$color %in% c("Black", "Gray", 
                                               "Silver", "White") 

str(usedcars)
CrossTable(usedcars$model, usedcars$conservative)
CrossTable(usedcars$model, usedcars$conservative, chisq=TRUE)
