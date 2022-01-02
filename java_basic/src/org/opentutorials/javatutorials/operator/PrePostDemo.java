package org.opentutorials.javatutorials.operator;

public class PrePostDemo {
    public static void main(String[] args) {
        int i = 3;
        i++;    // i++은 다 끝나고 1을 더해주고
        System.out.println(i);
        ++i;    // ++i는 1을 먼저 더하고 실행
        System.out.println(i);

        System.out.println(++i);
        System.out.println(i++);
        System.out.println(i);
    }
}
