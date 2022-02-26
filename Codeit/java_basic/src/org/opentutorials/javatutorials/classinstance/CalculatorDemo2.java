package org.opentutorials.javatutorials.classinstance;

// 멤버 = {변수, 메소드}

class Calculator2 {
    static double PI = 3.14;    // static 뒤에 변수는 클래스에 속하게되며, 모든 인스턴스가 클래스에서 이미 선언한, 항상 동일한, 고정된 값을 가지게 됨.

    static int base = 0;    // 클래스 변수인 base가 추가됨.
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right + base);
    }

    public void avg() {
        System.out.println((this.left + this.right + base) / 2);
    }

}

public class CalculatorDemo2 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sum();

        Calculator c2 = new Calculator();
        c2.setOprands(20, 40);
        c2.sum();

        Calculator2.base = 10;  // 클래스 외부에서 클래스변수 호출을 통해 변수를 변경할 수 있음
        c1.sum();
        c2.sum();

        System.out.println(Calculator.PI);  // 클래스 멤버이기 때문에 클래스 자체 네임을 통해서도 접근이 가능하다.
    }
}
