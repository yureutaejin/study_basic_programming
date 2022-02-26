f = open("data/vocabulary.txt", 'r')
'''
while True:
    for line in f:
        voca_list = (line.strip()).split(": ")
        kor_question = voca_list[1]
        eng_answer = voca_list[0]

        input_answer = input("{}: ".format(kor_question))
        if input_answer == eng_answer:
            print("맞았습니다.")
        else:
            print("아쉽습니다. 정답은 {}입니다.".format(eng_answer))
    break
f.close()
'''

temp_dict = {}
temp_list = []

for line in f:
    temp_list = line.strip().split(": ")
    temp_dict[temp_list[1]] = temp_list[0]

for key, value in temp_dict.items():
    input_answer = input(f"{key}: ")
    if input_answer == value:
        print("맞았습니다.")
    else:
        print(f"아쉽습니다. 정답은 {value}입니다.")

f.close()