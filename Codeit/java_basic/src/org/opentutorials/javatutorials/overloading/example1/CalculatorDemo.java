package org.opentutorials.javatutorials.overloading.example1;

class Calculator{
    int left, right;
    int third = 0;

    public void setOprands(int left, int right){
        System.out.println("setOprands(int left, int right)");
        this.left = left;
        this.right = right;
    }

    public void setOprands(int left, int right, int third){
        System.out.println("setOprands(int left, int right, int third)");
        this.setOprands(left, right);   // 객체의 첫번째 setOprands를 불러옴
        this.third = third;
    }

    public void sum(){
        System.out.println(this.left+this.right+this.third);
    }

    public void avg(){
        System.out.println((this.left+this.right+this.third)/3);
    }
}

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.setOprands(10, 20, 30);
        c1.sum();
        c1.avg();

    }

}

// 오버로딩은 동일한 네임의 메소드지만 다른 매개변수를 가진 메소드 생성, but (매개변수는 같지만 return이 다른 메소드)는 생성 불가