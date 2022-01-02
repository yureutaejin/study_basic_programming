package org.opentutorials.javatutorials.compare;

public class EqualStringDemo {
    public static void main(String[] args) {
        String a = "Hello world";
        String b = new String("Hello world");
        System.out.println(a == b);     // 값이 저장된 변수의 메모리 위치가 같은가?
        System.out.println(a.equals(b));    // 변수에 저장된 값 자체가 같은가?
    }
}
