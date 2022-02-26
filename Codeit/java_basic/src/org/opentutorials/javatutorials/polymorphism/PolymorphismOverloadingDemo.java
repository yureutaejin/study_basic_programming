package org.opentutorials.javatutorials.polymorphism;

// 오버로딩도 다형성 구현 중 하나

class O {
    public void a(int param) {
        System.out.println("숫자출력");
        System.out.println(param);
    }

    public void a(String param) {
        System.out.println("문자출력");
        System.out.println(param);
    }
}
public class PolymorphismOverloadingDemo {
    public static void main(String[] args) {
        O o = new O();
        o.a(1);
        o.a("one");
    }
}
