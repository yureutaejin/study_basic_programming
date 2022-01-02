package org.opentutorials.javatutorials.operator;

public class ArithmeticDemo {
    public static void main(String[] args) {
        int result = 1;

        System.out.println(result+=1);
        System.out.println(result -= 1);
        System.out.println(result *= 2);
        System.out.println(result / 2);
        System.out.println(result + 8 % 7);

        int a = 3;
        System.out.println(0%a);
        System.out.println(6%a);
    }
}
