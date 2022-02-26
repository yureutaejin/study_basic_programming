package org.opentutorials.javatutorials.generic.example5;
import java.lang.String.*;
// abstract Info{int getLevel();}
interface Info{
    int getLevel();
}
class EmployeeInfo implements Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{   // extends를 사용해야한다. => 부모가 누구냐를 묻는데 interface일 수도 있고 abstract class일 수도 있기 때문
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person(new EmployeeInfo(1));
//        Person<String> p2 = new Person<String>("부장");
    }
}