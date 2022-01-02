import random

def generate_numbers():

    answer = []
    while len(answer) != 3:
        r_num = random.randint(1, 9)
        if r_num in answer:
            continue
        else:
            answer.append(r_num)

    return answer

def take_guess():
    print("숫자 3개를 차례로 입력하세요.")
    input_num_list = []

    while len(input_num_list) != 3:
        input_num = int(input("{}번째 숫자를 입력하세요: ".format(len(input_num_list)+1)))

        if input_num in input_num_list:
            print("중복되는 숫자입니다. 다시 입력하세요.")
        elif (0 <= input_num <= 9) != True:
            print("범위를 벗어나는 숫자입니다. 다시 입력하세요.")
        else:
            input_num_list.append(input_num)

    return input_num_list

def get_score(guesses, solution):

    strikes = 0
    balls = 0

    for i in guesses:
        if i in solution:
            if guesses.index(i) == solution.index(i):
                strikes += 1
            else:
                balls += 1
        else:
            continue

    return strikes, balls
