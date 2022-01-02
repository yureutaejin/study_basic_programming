import function as f

print("0과 9 사이의 서로 다른 숫자 3개를 랜덤한 순서로 뽑았습니다.")

try_num = 1
answer = f.generate_numbers()
while True:
    input_guess = f.take_guess()

    s, b = f.get_score(answer, input_guess)

    if s != 3:
        try_num += 1
        print("{}S {}B\n".format(s, b))
        continue

    else:
        print("{}S {}B\n".format(s, b))
        print("축하합니다. {}번 만에 숫자 3개의 값과 위치를 모두 맞추셨습니다.".format(try_num))
        break