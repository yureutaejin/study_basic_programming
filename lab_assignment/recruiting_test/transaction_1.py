# temp.txt로부터 값 추출
def extraction():
    f = open('temp.txt', 'r')
    for line in f:
        line = line.strip().split()

    variable = int(line[2])

    return variable


# transaction
def atomicity_run(target_num):

    target_variable = extraction()

    # WAL (충돌방지기록)
    wal = extraction()
    # transaction 기록
    success = True

    while (target_variable != target_num):
        if (wal == extraction()):
            target_variable += 1

            # temp.txt 재작성
            f = open('temp.txt', 'w')
            f.write("TEMP = {}".format(target_variable))
            f.close()

            # wal 재기록
            wal = extraction()

            # transaction 성공여부
            success = True

        else:
            success = False
            break


    return success
