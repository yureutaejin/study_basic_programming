package org.opentutorials.javatutorials.finals;

class A {
    final void b(){}
}

//class B extends A{
//    void b() {}
//}

// final 메소드 b를 상속하려했기 때문에 오류가 발생

final class C {
    final void b() {}
}

//  class D extends C{}
// final 클래스를 상속하려했기 때문에 오류 발생