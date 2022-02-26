package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;
public class ArrayListDemo {
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        //arrayObj[3] = "three"; 오류가 발생한다.
        for (int i =0; i<arrayObj.length; i++) {
            System.out.println(arrayObj[i]);
        }

        ArrayList a1 = new ArrayList(); // 배열의 길이가 지정되어있지 않음
        a1.add("one");  // python list의 append 같은 느낌
        a1.add("two");  // add는 매개변수가 어떤 타입이든 대입할 수 있다.(Object 타입으로 저장)
        a1.add("three");

        for(int i =0; i<a1.size(); i++) {   // length가 아니라 size를 호출
            System.out.println(a1.get(i));  // 중괄호 호출이 아니라 get 메소드로 호출
        }

        for (int i = 0; i<a1.size(); i++){
            Object value = a1.get(i);
            // String value = a1.get(i); Object 타입을 String 타입의 변수에 저장하려하기 때문에 오류가 발생 -> 형변환 필요
            String value2 = (String) a1.get(i);
            System.out.println(value);
            System.out.println(value2); // arraylist 사용 시 원래의 데이터 타입으로 형변환 해줄 필요가 있다 => but, 옛날 방식
        }

        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("one");
        a2.add("two");
        a2.add("three");

        for (int i = 0; i < a2.size(); i++) {
            System.out.println(a2.get(i));
//            String val = a2.get(i);
//            System.out.println(val);
        }
    }
}
