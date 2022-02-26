# temp.txt로부터 값 추출
def extraction_2():
    f_2 = open('temp.txt', 'r')
    for line_2 in f_2:
        line_2 = line_2.strip().split()

    variable_2 = int(line_2[2])

    return variable_2


# transaction
def atomicity_run_2(target_num_2):

    target_variable_2 = extraction_2()

    # WAL (충돌방지기록)
    wal_2 = extraction_2()
    # transaction 기록
    success_2 = True

    while (target_variable_2 != target_num_2):
        if (wal_2 == extraction_2()):
            target_variable_2 += 1

            # temp.txt 재작성
            f_2 = open('temp.txt', 'w')
            f_2.write("TEMP = {}".format(target_variable_2))
            f_2.close()

            # wal 재기록
            wal_2 = extraction_2()

            # transaction 성공여부
            success_2 = True

        else:
            success_2 = False
            break


    return success_2
