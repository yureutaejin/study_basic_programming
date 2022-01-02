import transaction_1
import transaction_2
from multiprocessing import Process

# temp = 0인 txt 파일 작성
f = open('temp.txt', 'w')
f.write('TEMP = 0')
f.close()

#
if __name__ == '__main__':
    p1 = Process(target=transaction_1.atomicity_run, args=(1000000,))
    p2 = Process(target=transaction_2.atomicity_run_2, args=(1000000,))

    p1.start()
    p2.start()

    p1.join()
    p2.join()
