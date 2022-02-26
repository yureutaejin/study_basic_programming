package org.opentutorials.javatutorials.collection;

import java.util.*;

class Computer implements Comparable{   // Comparable 인터페이스
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    @Override
    public int compareTo(Object o) {    // Comparable 인터페이스 내의 compareTo 메소드
        return this.serial - ((Computer)o).serial;  // 양수, 0, 음수
    }
    public String toString(){
        return serial+" " + owner;
    }
}
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Computer> computers = new ArrayList<Computer>();  // List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));

        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());
        }
        Collections.sort(computers);    // Collection"s" 클래스 내에는 정렬과 관련된 클래스 메소들이 있다. sort는 list의 정렬을 수행
                                        // sort 실행시 내부적으로 compareTo 실행하고 그 결과에 따라서 객체의 선후 관계 판별
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
