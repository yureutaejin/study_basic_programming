def calculate_change(payment, cost):
    total_change = payment - cost
    digit = len(str(total_change))
    digit_storage = []
    unit_storage = [50000, 10000, 5000, 1000]

    for i in unit_storage:
        digit_storage.append(total_change // i)
        total_change -= digit_storage[-1]*i

    for i in range(0, 4, 1):
        print(f"{unit_storage[i]}원 지폐는 {digit_storage[i]}장")

calculate_change(100000, 33000)
print()
calculate_change(500000, 378000)