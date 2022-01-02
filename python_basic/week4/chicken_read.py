'''
with open('data/chicken.txt', 'r') as f:
    for line in f:

        # strip
        print(line.strip())
'''

'''
# split
my_string = "1. 2. 3. 4. 5. 6"
print(my_string.split(". "))

full_name = "Jin, Yuntae"
name_data = full_name.split(",")
print("".join(name_data))
'''

# practice
f = open('data/chicken.txt', 'r')
total_sales = 0
total_day = 0

for line in f:
    data = line.split(": ")
    total_sales += int(data[1])
    total_day += 1

mean_sales = total_sales / total_day
print(mean_sales)
f.close()
