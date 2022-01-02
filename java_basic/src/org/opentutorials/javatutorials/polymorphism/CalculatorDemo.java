package org.opentutorials.javatutorials.polymorphism;
abstract class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    int _sum() {
        return this.left + this.right;
    }
    public abstract void sum();
    public abstract void avg();
    public void run(){
        sum();
        avg();
    }
}
class CalculatorDecoPlus extends Calculator {
    public void sum(){
        System.out.println("+ sum :"+_sum());
    }
    public void avg(){
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
}
class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+(this.left+this.right)/2);
    }
}
public class CalculatorDemo {
    public static void execute(Calculator cal){
        System.out.println("실행결과");
        cal.run();
    }
    public static void main(String[] args) {
        Calculator c1 = new CalculatorDecoPlus();   // CalculatorDecoPlus 생성자로 만들어진 Calculator 클래스 타입을 가지고 있는 인스턴스 c1
        c1.setOprands(10, 20);

        Calculator c2 = new CalculatorDecoMinus();  // CalculatorDecoMinus 생성자로 만들어진 Calculator 클래스 타입을 가지고 있는 인스턴스 c1
        c2.setOprands(10, 20);

        execute(c1);
        execute(c2);
    }

}