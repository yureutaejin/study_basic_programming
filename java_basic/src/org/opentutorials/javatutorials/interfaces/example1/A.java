package org.opentutorials.javatutorials.interfaces.example1;

interface I{
    public void z();    // 추상메소드와 비슷, interface에서는 중괄호 부분 생략 후, 클래스에서 중괄호 포함 상세 작성
}
public class A implements I{
    public void z(){
        System.out.println("implements 구현");
    }

    public static void main(String[] args) {
        A a = new A();
        a.z();
    }
}

