package org.opentutorials.javatutorials.Inheritance.example1;

class MultiplicationableCalculator extends Calculator { // 같은 패키지이고 클래스는 각각 존재하므로 받아올 수 있다.
    public void multiplicaion() {
        System.out.println(this.left * this.right);
    }
}
public class CalculatorDemo2 {
    public static void main(String[] args) {
        MultiplicationableCalculator c1 = new MultiplicationableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.multiplicaion();
    }
}
