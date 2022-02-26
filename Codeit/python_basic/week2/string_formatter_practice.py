wage = 5
exchange_rate = 1142.16

print("{}시간에 {}원 벌었습니다.".format(wage, wage*exchange_rate))
print("%d시간에 %.1f원 벌었습니다."%(wage, exchange_rate *wage))
print("{0}시간에 {1:.1f}원 벌었습니다." .format(wage, exchange_rate*wage))
print("{num}시간에 {num2}원 벌었습니다.".format(num = wage, num2 = round(exchange_rate*wage, 1)))
print(f"{wage}시간에 {exchange_rate*wage}원 벌었습니다.")