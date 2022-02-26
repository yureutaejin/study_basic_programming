'''
a
b
c
a**2 + b**2 == c**2
a + b > c
a + b + c = 1000
'''
a = 0
b = 0

for i in range(1, 500, 1):
    for j in range(1, i, 1):
        if (i**2 + j**2 == (1000-i-j)**2):
            a = i
            b = j
            c = 1000-i-j
            break
    if b > 0:
        break

print(a*b*c)