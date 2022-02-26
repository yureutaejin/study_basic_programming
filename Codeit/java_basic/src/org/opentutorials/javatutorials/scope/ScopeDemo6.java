package org.opentutorials.javatutorials.scope;

public class ScopeDemo6 {
    static int i = 5;   // 전역변수 취급

    static void a() {
        int i = 10;
        b();
    }

    static void b() {
//      int i = 30; -> 30 출력됨 지역 변수 i가 생기기 때문
        System.out.println(i);
    }

    public static void main(String[] args) {
        int i = 1;
        a();    // 5 => 전역변수가 사용됨
    }
}
