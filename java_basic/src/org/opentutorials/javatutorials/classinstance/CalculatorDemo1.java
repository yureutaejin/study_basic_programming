package org.opentutorials.javatutorials.classinstance;

class Calculator {
    static double PI = 3.14;    // static 뒤에 변수는 클래스에 속하게되며 클래스에서 이미 선언한, 항상 동일한, 고정된 값을 가지게 됨.
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }

}

public class CalculatorDemo1 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);

        Calculator c2 = new Calculator();
        System.out.println(c2.PI);

        System.out.println(Calculator.PI);  // 클래스 멤버이기 때문에 클래스 자체 네임을 통해서도 접근이 가능하다.
    }
}
