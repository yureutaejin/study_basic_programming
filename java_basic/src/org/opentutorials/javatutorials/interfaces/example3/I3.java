package org.opentutorials.javatutorials.interfaces.example3;

// 인터페이스도 상속이 된다.
interface I3 {
    public void x();
}

interface I4 extends I3 {
    public void z();
}

class B implements I4 {
    @Override
    public void x() {
    }

    @Override
    public void z() {

    }
}
