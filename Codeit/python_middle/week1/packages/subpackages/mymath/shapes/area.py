
def circle(r):
    return (r**2)*3.14

def square(r):
    return r**2

def main():
    print(circle(3)==9*3.14)
    print(square(2)==4)

    # __name__ (던더 네임) : import 할 경우
    # __main__ (던더 메인) : 직접 스크립트로 실행할 경우
    print('run 파일 이름: {}'.format(__name__))

if __name__=='__main__':
    main()