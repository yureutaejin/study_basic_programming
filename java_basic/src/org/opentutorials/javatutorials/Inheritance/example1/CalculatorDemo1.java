package org.opentutorials.javatutorials.Inheritance.example1;

class Calculator {
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

class SubstractionableCalculator extends Calculator {   // extends로 상속받음
    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorDemo1 {

    public static void main(String[] args) {

        SubstractionableCalculator c1 = new SubstractionableCalculator();   // 상속했으므로 Calculator의 메소드도 동일하게 사용이 가능하다.
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }

}
