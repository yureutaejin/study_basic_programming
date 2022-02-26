# print 50 fibonacci sequence

i = 1
first = 1
second = 1

while i != 51:
    print(first)
    first, second = second, first+second
    i += 1