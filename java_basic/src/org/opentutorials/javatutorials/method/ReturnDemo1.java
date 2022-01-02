package org.opentutorials.javatutorials.method;

public class ReturnDemo1 {

    public static String[] getMembers() {
        String[] members = {"최진혁", "최유빈", "한이람"};
        return members;
    }

    public static void main(String[] args) {
        String[] members = getMembers();

        for (String i : members) {
            System.out.println(i);
        }
    }

}
