package org.opentutorials.javatutorials.classinstance;

// 인스턴스 메서드는 반드시 객체를 생성해야만 호출이 가능하고
// 클래스 메서드는 객체를 생성하지 않아도 됨 (static만 붙으면 class 메소드)
class C {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(v);  // 지역변수에 20이 들어가있음. 지역변수가 전역변수보다 우선순위가 높음.
        System.out.println(this.v); // this는 인스턴스를 의미하며 this.변수는 전역변수의 의미를 가지게 된다.
    }
}
public class ScopeDemo7 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.m();
    }
}
