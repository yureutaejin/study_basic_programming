# 2.1
blood = c('B', 'A', 'B', 'A', 'A', 'B', 'O', 'A', 'A', 'A', 'O', 'B', 'B', 'A', 'A', 'O', 'O', 'A', 'B', 'O', 'B', 'B', 'A', 'A', 'O', 'A', 'A', 'B', 'B', 'O', 'B', 'B', 'B', 'A', 'A', 'A', 'B', 'O', 'B', 'B', 'O', 'B', 'O', 'B', 'A', 'A', 'A', 'A', 'AB', 'AB', 'AB', 'AB', 'AB', 'AB', 'AB')
cnt = table(blood)
prop = prop.table(cnt)
cbind(cnt, prop)
barplot(cnt)
pie(cnt)

# 2.2
height = c(170, 178, 171, 168, 173, 178, 171, 174, 170, 170, 175, 170, 169, 166, 162, 170, 171, 175, 175, 171, 171, 170, 172, 179, 164, 170, 181, 178, 180, 177, 166, 169, 168, 165, 163, 175, 166, 178, 165, 168, 167, 177, 168, 177, 174, 174, 176, 179, 169, 173, 167, 170, 173, 170, 162)
cut = c(161.5, 165.5, 169.5, 173.5, 177.5, 181.5)
hist(height, breaks = cut, probability = T)

#2.3
noise = c(55.9, 63.8, 57.2, 59.8, 65.7, 62.7, 60.8, 51.3, 61.8, 56.0, 66.9, 56.8, 66.2, 64.6, 59.5, 63.1, 60.6, 62.0, 59.4, 67.2, 63.6, 60.5, 66.8, 61.8, 64.8, 55.8, 55.7, 77.1, 62.1, 61.0, 58.9, 60.0, 66.9, 61.7, 60.3, 51.5, 67.0, 60.2, 56.2, 59.4, 67.9, 64.9, 55.7, 61.4, 62.6, 56.4, 56.4, 69.4, 57.6, 63.8)
mean(noise)
var(noise)
sd(noise)
quantile(noise, type=2)
boxplot(noise, horizontal = T)

# 연습문제 2.1
season = c('봄', '봄', '봄', '봄', '봄', '봄', '봄', '봄', '여름', '여름', '여름', '여름', '여름', '여름', '여름', '여름', '여름', '가을', '가을', '가을', '가을', '가을', '가을', '가을', '가을', '가을', '가을', '겨울', '겨울', '겨울', '겨울', '겨울', '겨울', '겨울')
cnt = table(season)
prop = prop.table(cnt)
cbind(cnt, prop)
barplot(cnt)
pie(cnt)

# 연습문제 2.2
math_score = c(77, 78, 76, 81, 86, 51, 79, 82, 84, 99)
resident_A = c(1, 5, 2, 3, 2, 1, 4, 1, 3)

mean(math_score)
mean(resident_A)

median(math_score)
median(resident_A)

# 연습문제 2.3
var(math_score)
var(resident_A)

sd(math_score)
sd(resident_A)

# 연습문제 2.4
quantile(math_score)
quantile(resident_A)

# 연습문제 2.7
semina_mind = c(3, 8, -1, 2, 0, 5, -3, 1, -1, 6, 5, -2)
mean(semina_mind)
sd(semina_mind)
median(semina_mind)

# 연습문제 2.8
japanese_american = c(2568, 2230, 6355, 4181, 3651, 3317, 2871)
japanese_american/27873
barplot(japanese_american/278730)

# 연습문제 2.9
football_weight = c(101, 177, 178, 184, 185, 185, 185, 185, 188, 190, 200, 205, 205, 206, 210, 210, 210, 212, 212, 215, 215, 220, 223, 228, 230, 232, 241, 241, 242, 245, 247, 250, 250, 259, 260, 260, 265, 265, 270, 272, 273, 275, 276, 278, 280, 280, 285, 285, 286, 290, 290, 295, 302)

mean(football_weight)
median(football_weight)
quantile(football_weight)
boxplot(football_weight, horizontal = T)
