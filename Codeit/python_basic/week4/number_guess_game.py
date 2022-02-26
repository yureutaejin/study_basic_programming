import random

answer = random.randint(1 ,20)
chance = 4


while chance != 0:
    input_answer = int(input("기회가 {}번 남았습니다. 1-20 사이의 숫자를 맞혀 보세요: ".format(chance)))

    if input_answer == answer:
        print( "축하합니다. {}번 만에 숫자를 맞히셨습니다.".format(5-chance))
        break

    elif (input_answer != answer) and (chance == 1):
        print("아쉽습니다. 정답은 {}입니다.".format(answer))
        break

    else:
        if input_answer > answer:
            print("Down")
            chance -= 1

        elif input_answer < answer:
            print("Up")
            chance -= 1
