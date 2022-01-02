package org.opentutorials.javatutorials.interfaces.example2;

class Calculator implements Calculatable {
    int first, second, third;

    @Override
    public void setOprands(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int sum() {
        return first+second+third;
    }

    @Override
    public int avg() {
        return (this.sum()/3);
    }
}

public class CalculatorConsumer {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setOprands(10, 20, 30);
        System.out.println(c.sum()+c.avg());

    }
}
