package org.opentutorials.javatutorials.Inheritance.example1;

class DivisionableCalculaor extends MultiplicationableCalculator {
    public void division() {
        System.out.println(this.left / this.right); // 상속의 상속
    }
}

public class CalculatorDemo3 {
    public static void main(String[] args) {
        MultiplicationableCalculator c1 = new MultiplicationableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.multiplicaion();
    }
}
