package org.opentutorials.javatutorials.collection;
import java.util.Collection;
import java.util.*;

public class MapDemo {

    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();   // 메소드 entrySet은 Map의 데이터를 담고있는 Set을 반환. 반환한 Set의 값이 사용할 데이터 타입은 Map.Entry
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());  // Map.Entry 인터페이스의 두가지 API => getKey, getValue
        }
    }

    static void iteratorUsingIterator(HashMap map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()) {
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>();    // key값은 중복 불가, value 값은 중복 허용
        a.put("one", 1);    // put은 Map에만 존재
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        a.put("하나", 1);
        System.out.println(a.get("one"));   // key값을 대입해서 value를 가져옴
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));
        System.out.println(a.get("four"));
        System.out.println(a.get("하나"));

        System.out.println();

        iteratorUsingForEach(a);
        System.out.println();
        iteratorUsingIterator(a);
    }
}
