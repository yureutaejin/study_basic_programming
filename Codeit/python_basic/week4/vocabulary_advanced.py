import random
f = open("data/vocabulary.txt", 'r')

kor_question = []
eng_answer = []

for line in f:
    voca_list = line.strip().split(": ")
    kor_question.append(voca_list[1])
    eng_answer.append(voca_list[0])

while True:
    random_select = random.randint(0, len(kor_question) - 1)
    input_answer = input(f"{kor_question[random_select]}: ")

    if input_answer == 'q':
        break

    else:
        if input_answer == eng_answer[random_select]:
            print("맞았습니다.")
            continue
        else:
            print("틀렸습니다. 정답은 {}입니다.".format(eng_answer[random_select]))
            continue
    break