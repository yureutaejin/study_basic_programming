package org.opentutorials.javatutorials.object;

// 클래스는 연관되어 있는 변수와 메소드의 집합
class Calculator {
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;   // 인스턴스의 left, right 변수(인스턴스의 멤버: 인스턴스를 만들어야 사용할 수 있고 인스턴스마다 서로 다른 값을 가지고 있기 때문)에 setOprands안의 left, right를 배정해줌
        this.right = right; // this는 인스턴스 자체를 의미
    }

    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}

public class CalculatorDemo4 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();   // Calculator 클래스를 이용해서 new Calculator(구체적인 제품으로 만드는 명령어)로 인스턴스를 만들고 변수 c1에 저장. 변수의 데이터 타입은 그 클래스가 된다.
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();

        Calculator c2 = new Calculator();   // 인스턴스 생성
        c2.setOprands(20, 40);
        c2.sum();
        c2.avg();

    }
}
