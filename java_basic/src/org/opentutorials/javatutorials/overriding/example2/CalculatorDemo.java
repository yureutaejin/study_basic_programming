package org.opentutorials.javatutorials.overriding.example2;

class Calculator {
    int left, right;

    public Calculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public int avg() {
        return ((this.left + this.right) / 2);
    }
}

class SubstractableCalculator extends Calculator {
    public SubstractableCalculator(int left, int right) {
        super(left, right); // 부모 클래스의 생성자에, 파라미터를 대입
    }
    public void sum() {
        System.out.println("실행결과는 "+ (this.right + this.left) + "입니다.");
    }
    public int avg(){
        return super.avg(); // 부모클래스의 메소드도 받아올 수 있다.
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}


public class CalculatorDemo {
    public static void main(String[] args) {
        SubstractableCalculator c1 = new SubstractableCalculator(10, 20);
        c1.sum();
        System.out.println(c1.avg());
        c1.substract();
    }
}