package org.opentutorials.javatutorials.method;

public class MethodDemo4 {
    public static String numbering(int init, int limit) {   // 리턴 값이 있다면 메소드 명앞에 리턴 값의 타입을 명시
        int i = init;
        String output = "";
        while (i < limit) {
            output += i;
            i++;
        }
        return output;
    }

    public static void main(String[] args) {    // void: 리턴 값이 없다, 존재하지 않는다.
        String result = numbering(1, 5);
        System.out.println(result);
    }
}
