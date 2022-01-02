package basic_method;

import java.util.*;
public class ToyStack {
    public static void main(String[] args) {
        Stack<String> toys = new Stack<String>();
        toys.push("Red YOYO");
        toys.push("Black COOKIE MAN");
        toys.push("Blue NINJA");

        System.out.println("peek: "+ toys.peek());
        System.out.println("size: "+ toys.size());
        System.out.println("pop: "+ toys.pop());
        toys.push("Yellow YOYO");
        System.out.println(toys.toString());  // 논리적인 스택에서는 요소를 다 볼 수 없지만 toString으로 관찰가능


    }
}
