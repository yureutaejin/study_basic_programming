package hackerrank_Java_Stack;

import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack stack = new Stack();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if ('(' == c || '{' == c || '[' == c) {
                    stack.push(input);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(input);
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }

}