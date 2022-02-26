package org.opentutorials.javatutorials.collection;

import org.opentutorials.javatutorials.interfaces.example1.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Iterator;


//
public class SetDemo {
    public static void main(String[] args) {

        ArrayList<Integer> A_arraylist = new ArrayList<Integer>();
        A_arraylist.add(1);
        A_arraylist.add(2);
        A_arraylist.add(2);
        A_arraylist.add(2);
        A_arraylist.add(2);
        A_arraylist.add(3);

        Iterator hi = (Iterator) A_arraylist.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());  // list는 중복을 허용 -> 입력한 모든 값들이 저장됨
        }
        System.out.println();

        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(2);
        A.add(2);
        A.add(3);

        Iterator hi2 = (Iterator) A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());  // Set은 중복을 허용하지 않음 -> 입력한 '고유의' 값들만 저장됨, 순서 x
        }
        System.out.println();

        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);

        // A.containsAll(B)  부분집합
        System.out.println(A.containsAll(B));   // false
        System.out.println(A.containsAll(C));   // true

        A.addAll(B);    // 합집합
        // A.retainAll(B);  // 교집합
        // A.removeAll(B);  // 차집합

        Iterator hi3 = (Iterator) A.iterator();
        while(hi3.hasNext()){
            System.out.println(hi3.next());
        }
    }
}
