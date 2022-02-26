package org.opentutorials.javatutorials.collection;
import org.opentutorials.javatutorials.interfaces.example1.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Iterator는 collection 인터페이스 안 모든 클래스들이 공통적으로 가지고있는 API이다.
// Collection이 인터페이스이므로 생성자가 Collection 인터페이스 내 클래스라면, 데이터타입을 Collection으로 지정하는 것도 가능하다.
public class Iterator_example {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator(); // iterator 메소드의 return 값은 Iterator 타입의 객체를 리턴, 즉 타입만 바꿔서 hi로 복사
        while(hi.hasNext()){    // hi 안에 값이 있으면 true 없으면 false
            System.out.println(hi.next());  // hi 안에 하나의 값을 리턴해주고 하나씩 지워줌 (A가 아닌 Iterator 타입의 hi 안에서만 지움)
        }

        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);

        Iterator hi2 = B.iterator();
        while(hi2.hasNext()){
            System.out.println(hi2.next());
        }
    }
}
