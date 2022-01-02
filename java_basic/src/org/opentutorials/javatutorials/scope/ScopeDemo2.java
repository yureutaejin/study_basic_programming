package org.opentutorials.javatutorials.scope;

public class ScopeDemo2 {
    static int i;   // 클래스 바로 밑에 있어 전역변수(global)
    static void a() {
        i = 0;  // 지역변수(local) -> 그런데 앞에 타입을 안 적어주어 동일한 네임의 위 전역변수를 가져오게 됨.
    }

    public static void main(String[] args) {
        for (i = 0; i<5; i++) { // i에 int를 붙이지 않아 위에서 가져옴 -> main 메소드 내 지역변수로 선언하지 않아 똑같이 전역변수 i 사용
            a();
            System.out.println(i);
        }
    }

}
