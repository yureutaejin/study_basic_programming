package org.opentutorials.javatutorials.array;

public class LengthDemo {
    public static void main(String[] args) {
        String[] classGroup = new String[4];
        classGroup[0] = "최진혁";
        System.out.println(classGroup.length);  // 자바는 배열의 길이를 미리 정해주기 때문에 length가 들어간 값들의 길이가 아닌 배열의 최대 길이를 return한다.
        classGroup[1] = "최유빈";
        System.out.println(classGroup.length);
        classGroup[2] = "한이람";
        System.out.println(classGroup.length);
        classGroup[3] = "이고잉";
        System.out.println(classGroup.length);
    }
}
