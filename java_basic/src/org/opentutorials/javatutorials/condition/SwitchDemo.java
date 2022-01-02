package org.opentutorials.javatutorials.condition;

public class SwitchDemo {
    public static void main(String[] args) {
        System.out.println("switch(1)");
        // 앞에서 case 통과 시 순차적으로 뒷 case문도 실행됨
        // break로 막음
        switch(4) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
        }
        System.out.println();

        int val = 1;
        if (val == 1){
            System.out.println("one");
        } else if (val == 2) {
            System.out.println("two");
        } else if (val == 3) {
            System.out.println("three");
        }

        System.out.println();
        System.out.println("switch(2)");
        switch(2) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
        }

        System.out.println("switch(3)");
        switch(3) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
        }
    }
}
