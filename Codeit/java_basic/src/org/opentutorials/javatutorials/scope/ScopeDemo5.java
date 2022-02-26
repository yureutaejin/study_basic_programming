package org.opentutorials.javatutorials.scope;

public class ScopeDemo5 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);  // i가 for 내에서만 정의됨.
        }
        // System.out.println(i);
    }
}
