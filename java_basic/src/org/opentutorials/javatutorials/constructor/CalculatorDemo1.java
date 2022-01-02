package org.opentutorials.javatutorials.constructor;

class Calculator {
    int left, right;

    public Calculator(int left, int right) {    // 생성자(constructor) -> 클래스가 생성될 때 클래스와 동일한 이름의 메소드는 어떠한 메소드보다 먼저 시작됨
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left+this.right)/2);
    }
}

public class CalculatorDemo1 {
    public static void main(String[] args) {

        Calculator c1 = new Calculator(20, 30); // new 뒤의 Calculator는 생성자이다.
        c1.sum();

        Calculator c2 = new Calculator(40, 5);
        c2.avg();

    }
}

// 생성자의 특징
// 값을 반환하지 않는다. -> 생성자는 인스턴스를 생성해주는 역할을 하는 특수한 메소드. 반환 값을 필요로하는 작업에서는 생성자 사용x
// 생성자의 이름은 클래스의 이름과 동일