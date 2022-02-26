package org.opentutorials.javatutorials.polymorphism;

class A {
    public String x(){return "A.x";}
}
class B extends A{
    public String x() {return "B.x;";}
    public String y(){
        return "B.y;";
    }
}

class B2 extends A {
    public String x(){
        return "B2.x;";
    }
}

public class PolymorphismDemo1 {
    public static void main(String[] args) {
        A obj = new B(); // B의 생성자로 obj 인스턴스를 형성햇으나 데이터타입은 A를 따르게 할 수도 있음. B가 A에게 상속받았기 때문에 가능
        A obj2 = new B2();
        B obj3 = new B();
        System.out.println(obj.x());    // obj는 클래스 A의 형태를 취하고 있지만 멤버는 클래스 B의 것을 따른다.(오버라이딩 됐을 때), 클래스 A의 형태를 취하고 있으므로 A 멤버에 없는 것은 실행 불가
//        obj.y();  // 부모 클래스 A를 따르므로 자식 클래스 B의 메소드 y를 사용하지 못 함.
        System.out.println(obj2.x());
        System.out.println(obj3.y());   // 클래스 B의 타입을 따르므로 메소드 y까지 실행가능

    }
}
