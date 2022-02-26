package org.opentutorials.javatutorials.io;

public class InputForeachDemo {
    public static void main(String[] args) {
        for(String e : args) {
            System.out.println(e);
        }
    }
}
// 터미널에서 bin이나 out 폴더 진입 후 실행 -> java org.opentutorials.javatutorials.io.InputForeachDemo one two three
// 귀찮으면 configurations에서 미리 대입 후 그냥 run
