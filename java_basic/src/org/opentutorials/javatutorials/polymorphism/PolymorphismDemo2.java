package org.opentutorials.javatutorials.polymorphism;
interface I{
    void example();
}
class C implements I{
    public void example(){
        System.out.println("example");
    }

    public void example2(){
        System.out.println("example 2");
    }

}

public class PolymorphismDemo2 {
    public static void main(String[] args) {
        I obj = new C();  // 인터페이스 또한 데이터 타입으로 지정할 수 있다.

        C obj2 = new C();

        obj.example();
        // obj.example2();
        obj2.example();
        obj2.example2();
    }
}
