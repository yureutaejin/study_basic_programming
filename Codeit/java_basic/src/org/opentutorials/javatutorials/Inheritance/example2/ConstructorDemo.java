package org.opentutorials.javatutorials.Inheritance.example2;

public class ConstructorDemo {
    public ConstructorDemo() {} // 10번줄에서는 파라미터가 없는 생성자를 호출 중이기 때문에 빈 생성자를 생성해준다.
    public ConstructorDemo(int param1) {}
    public static void main(String[] args) {
//        ConstructorDemo c = new ConstructorDemo(); => ConstructorDemo 클래스는 어떠한 생성자도 가지고 있지 않은 상태
//                                                      자바가 실행시 자동으로 기본 생성자(매개변수가 없는)을 생성해줌

        ConstructorDemo c = new ConstructorDemo();

        ConstructorDemo c2 = new ConstructorDemo(1);
    }
}
