package org.opentutorials.javatutorials.overriding.example1;

class Calculator {
    int left, right;

    public Calculator(int left, int right) {
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

class SubstractableCalculator extends Calculator {
    public SubstractableCalculator(int left, int right) {
        super(left, right);
    }
    public void sum() {
        System.out.println("실행결과는 "+ (this.right + this.left) + "입니다.");
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}
// 메소드 sum이  SubstractionableCalculator에 추가 되었다.
// 실행결과는 c1.sum이 상위 클래스의 메소드가 아니라 하위 클래스의 메소드 sum을 실행하고 있다는 것을 보여준다.
// 하위 클래스 입장에서 부모 클래스란 말하자면 기본적인 동작 방법을 정의한 것이라고 생각할 수 있다.
// 하위 클래스에서 상의 클래스와 동일한 메소드를 정의하면 부모 클래스로부터 물려 받은 기본 동작 방법을 변경하는 효과를 갖게 된다.
// 기본동작은 폭넓게 적용되고, 예외적인 동작은 더 높은 우선순위를 갖게하고 있다.
// 이것은 공학에서 일반적으로 발견되는 규칙이다. 이것을 메소드 오버라이딩(overriding)이라고 한다.

// 오버라이딩을 위해서는 1) 메소드의 이름 2) 메소드의 매개변수의 숫자와 데이터타입 그리고 순서 3) 메소드의 리턴 타입 등이 같아야한다.

public class CalculatorDemo {
    public static void main(String[] args) {
        SubstractableCalculator c1 = new SubstractableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}
