package org.opentutorials.javatutorials.condition;

public class LoginDemo2 {
    public static void main(String[] args) {
        String id = args[0]; // 0번째로 아이디 값
        String password = args[1]; // 1번째로 비밀번호 값
        // 입력 시 egoing 111111 입력해줘야함

        if (id.equals("egoing")) {
            if (password.equals("111111")) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        } else {
            System.out.println("wrong");
        }
    }
}
