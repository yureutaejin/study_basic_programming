package org.opentutorials.javatutorials.generic.example1;

class A <T> {
    public T info;
}

// 제네릭은 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미.

public class GenericDemo {
    public static void main(String[] args) {

        A<String> p1 = new A <String>();

        A<StringBuilder> p2 = new A <StringBuilder>();
    }
}
