package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A {
    public abstract void b();
    // 본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
    // 멤버 중 하나라도 abstract라면 클래스도 자동으로 abstract다.
    // public  abstract int c() { System.out.println("Hello") }

    // 추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재할 수 있다.
    public void d() {
        System.out.println("world");
    }
}

class B extends A { // 상속해서 사용. 즉, 추상 클래스는 상속을 강제하고 있음.
    public void b(){
        System.out.println(1);  // 반드시 추상클래스 내 추상메소드를 오버라이딩
    }

}

public class AbstractDemo {
    public static void main(String[] args) {
        // A obj = new A();
        B obj = new B();
        obj.b();
    }
}
