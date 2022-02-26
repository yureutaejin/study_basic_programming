# 자리수 합 리턴
def sum_digit(num):
    sum = 0
    digit = len(str(num))
    for i in range(digit):
        sum += num // 10**(digit-1-i)
        num %= 10**(digit-1-i)
    return sum
    # 코드를 입력하세요.


# sum_digit(1)부터 sum_digit(1000)까지의 합 구하기
# 코드를 입력하세요.

total = 0
for i in range(1, 1001, 1):
    total += sum_digit(i)

print(total)