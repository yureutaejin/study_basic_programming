package org.opentutorials.javatutorials.finals;

class Calculator {
    static final double PI = 3.14;  // final 없이는 원한다면 고칠 수 있었음.
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left+this.right);
    }

    public void avg() {
        System.out.println((this.left+this.right)/2);
    }
}
public class CalculatorDemo1 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);

//      Calculator.PI = 6; // 위의 final을 지워보고 사용
        System.out.println(Calculator.PI);

    }
}

// final로 지정된 변수에는 한번 값이 할당되면 그 값을 바꿀 수 없음. 클래스 변수만이 아니라 인스턴스 변수도 동일