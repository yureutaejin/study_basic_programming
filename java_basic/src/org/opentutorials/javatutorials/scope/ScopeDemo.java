package org.opentutorials.javatutorials.scope;

public class ScopeDemo {
    static void a() {
        int i = 0;
    }   // 변수 i가 메소드 a에 소속된 변수라는 의미

    public static void main(String[] args) {
        for (int i =0; i <5; i++) {
            a();    // 충돌 발생
            System.out.println(i);
        }
    }
}
