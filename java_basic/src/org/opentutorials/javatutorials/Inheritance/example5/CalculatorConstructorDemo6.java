package org.opentutorials.javatutorials.Inheritance.example5;

class Calculator {
    int left, right;

    public Calculator() {}  // super가 있다면 지워도 되는 라인

    public Calculator(int left, int right){
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
class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {
        super(left, right);
        // super가 아니라면 this.left = left; this.right = right;라고 써야하는데, 이렇게 쓰면 하위클래스에서 인스턴스 변수를 재설정해주는 것이므로 6번 줄에 빈 생성자가 필요하다.
        // super => 부모클래스를 의미, super(left, right) 부모 클래스 생성자에게 자식 생성자 파라미터에서 정의된 left와 right을 넘겨줘라
        // super 선언시 부모클래스의 기본 생성자가 없어져도 오류 발생 x
        // 상위클래스에서 초기화 작업이 다 끝나야만 하위클래스에서 초기화 작업이 가능하므로 super위에 초기화는 불가
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo6 {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}