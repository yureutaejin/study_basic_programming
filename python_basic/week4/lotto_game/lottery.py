import random

def generate_numbers(n):
    random_list = []

    while len(random_list) != n:
        r_num = random.randint(1, 45)
        if r_num in random_list:
            continue
        else:
            random_list.append(r_num)

    return random_list

def draw_winning_numbers():
    select_num = generate_numbers(7)
    normal_num = sorted(select_num[:6])
    special_num = select_num[-1:]
    result = normal_num + special_num
    return result

def count_matching_numbers(list_1, list_2):
    matching_numbers = []
    for i in list_1:
        if i in list_2:
            matching_numbers.append(i)

    return len(matching_numbers)

def check(list_1, list_2):
    normal_check = count_matching_numbers(list_1[0:], list_2[0:6])
    special_check = list_2[6] in list_1
    prize = 0

    if normal_check == 6:
        prize = 1000000000
    elif (normal_check == 5) and special_check:
        prize = 50000000
    elif normal_check == 5:
        prize = 1000000
    elif normal_check == 4:
        prize = 50000
    elif normal_check == 3:
        prize = 5000

    return prize

numbers_test = [2, 4, 11, 14, 25, 40]
winning_numbers_test = [2, 4, 10, 11, 14, 40, 25]

print(check(numbers_test, winning_numbers_test))