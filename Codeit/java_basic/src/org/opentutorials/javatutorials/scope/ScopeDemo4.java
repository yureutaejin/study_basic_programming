package org.opentutorials.javatutorials.scope;

public class ScopeDemo4 {
    static void a(){
        String title = "coding everybody";  // 메소드 내 변수 title
    }

    public static void main(String[] args) {
        a();
        // System.out.println(title); // main 메소는 찾을 수 없다.
    }
}
