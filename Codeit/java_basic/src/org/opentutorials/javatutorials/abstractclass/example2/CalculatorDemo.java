package org.opentutorials.javatutorials.abstractclass.example2;

abstract class Calculator {
    int left, right;
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public abstract void sum();
    public abstract void avg();
    public void run(){
        sum();
        avg();
    }
}

class CalculatorDecoPlus extends Calculator {
    public void sum() {
        System.out.println("+ sum :"+(this.left+this.right));
    }
    public void avg() {
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
}

class CalculatorDecoMinus extends Calculator {
    public void sum() {
        System.out.println("- sum :"+(this.left+this.right));
    }

    public void avg() {
        System.out.println(("- avg :"+(this.left+this.right)/2));
    }
}


public class CalculatorDemo {
    public static void main(String[] args) {
        CalculatorDecoPlus c1 = new CalculatorDecoPlus();
        c1.setOprands(10, 20);
        c1.run();

        CalculatorDecoMinus c2 = new CalculatorDecoMinus();
        c2.setOprands(10,20);
        c2.run();
    }
}

// 대형 프로젝트에서 메소드의 시그니쳐만 구현하고 상속으로 하나씩 처리해서 만듦