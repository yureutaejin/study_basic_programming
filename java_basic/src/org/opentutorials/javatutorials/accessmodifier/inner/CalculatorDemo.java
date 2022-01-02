package org.opentutorials.javatutorials.accessmodifier.inner;

class Calculator {
    private int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    private int _sum() {
        return this.left+this.right;
    }

    public void sumDecoPlus(){
        System.out.println("++++"+_sum()+"++++");
    }

    public void sumDecoMinus() {
        System.out.println("----"+_sum()+"----");
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sumDecoPlus();   // sumDecoPlus()라는 인스턴스 메소드로 private화 된 _sum() 메소드에 접근 가능 => 같은 클래스이기 때문이다.
        c1.sumDecoMinus();
    }
}

// private -> 반드시 같은 패키지이고 같은 클래스끼리만 접근 허용
// default -> 같은 패키지일 때, 상속이든 상속 관계가 아니든 접근을 허용한다.
// protected -> 다른 패키지이고 상속 관계일 때, 접근을 허용한다.
// public -> 접근을 전부 허용
// 접근제어자가 생략되었을 때 자동으로 default 접근 제어자를 할당한다.
