package org.opentutorials.javatutorials.accessmodifier.inner;

class A {
    public String y() {
        return "public void y()";
    }

    private String z() {
        return "public void z()";   // 외부의 클래스는 사용이 불가능하다.
    }

    public String x() {
        return z();
    }
}
public class AccessDemo1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.y());
//        System.out.println(a.z()); private으로 인해 오류발생
        System.out.println(a.x());  // 먼저 A 클래스로 인스턴스 a 만들고 인스턴스 a의 인스턴스 메소드 x가 z를 호출하므로 사용이 가능하다.
    }
}

// 접근 제어자 사용 이유: 객체를 사용하는 입장에서 객체 내부적으로 사용하는 변수나 메소드에 접근함으로서 개발자가 의도하지 못한 오동작을 막음
