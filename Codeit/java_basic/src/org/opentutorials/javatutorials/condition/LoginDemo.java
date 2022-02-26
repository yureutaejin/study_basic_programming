package org.opentutorials.javatutorials.condition;

public class LoginDemo {
    public static void main(String[] args) {
        String id = args[0];    // 입력 값 -> configurations argument에 egoing 입력해주기 or class파일 컴파일 해주고 터미널에서 egoing만 붙여주기
        if(id.equals("egoing")) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}
