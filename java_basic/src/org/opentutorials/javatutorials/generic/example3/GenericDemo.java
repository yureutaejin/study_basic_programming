package org.opentutorials.javatutorials.generic.example3;
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
}
public class GenericDemo {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);    // Wrapper class
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        System.out.println(p1.id.intValue());   // Wrapper class가 담고있는 수를 원시데이터타입인 int 값으로 출력
        System.out.println(p1.info.rank);
    }
}