package org.opentutorials.javatutorials.classinstance;

class Calculator3 {
    public static void sum(int left, int right) {
        System.out.println(left + right);
    }

    public static void avg(int left, int right) {
        System.out.println((left+right)/2);
    }

}
public class CalculatorDemo3 {
    public static void main(String[] args) {
        Calculator3.sum(10, 20);    // 인스턴스를 굳이 사용하지 않아도 클래스 내 메소드를 사용하여 구현 가능
        Calculator3.avg(10, 20);    // 메소드가 인스턴스 변수를 참조하지 않는다면 클래스 메소드를 사용해서 불필요한 인스턴스의 생성을 막을 수 있다.
        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
    }
}
