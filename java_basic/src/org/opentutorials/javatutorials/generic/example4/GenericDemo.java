package org.opentutorials.javatutorials.generic.example4;
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){  // 메소드 레벨에서도 제네릭 사용가능
        System.out.println(info);
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
//        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        Person p1 = new Person(e, i); // 제네릭 생략 => 생성자의 매개변수 e, i를 통해서 자바는 데이터타입을 알 수 있기 때문이다.
        p1.<Integer>printInfo(i);   // p1.printinfo(i);
        p1.<EmployeeInfo>printInfo(e);  // p1.printinfo(e);

    }
}
