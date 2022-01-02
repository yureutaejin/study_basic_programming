f = open("data/vocabulary.txt", 'w')

while True:
    eng_voca = input("영어 단어를 입력하세요: ")

    if eng_voca == "q":
        f.close()
        break

    kor_voca = input("한국어 뜻을 입력하세요: ")

    if kor_voca == "q":
        f.close()
        break

    f.write("{}: {}\n".format(eng_voca, kor_voca))