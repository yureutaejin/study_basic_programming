package org.opentutorials.javatutorials.generic.example2;

class StudentInfo{
    public int grade;
    StudentInfo(int grade) { this.grade = grade;}
}

//class StudentPerson{
//    public StudentInfo info;
//    StudentPerson(StudentInfo info){ this.info = info; }
//}

class EmployeeInfo {
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}

//class EmployeePerson {
//    public EmployeeInfo info;
//    EmployeePerson(EmployeeInfo info) { this.info = info; }
//}

class Person {
    public Object info;
    Person(Object info) { this.info = info; }
}

public class GenericDemo2 {
    public static void main(String[] args) {

//        StudentInfo si = new StudentInfo(2);
//        StudentPerson sp = new StudentPerson(si);
//        System.out.println(sp.info.grade);
//        EmployeeInfo ei = new EmployeeInfo(1);
//        EmployeePerson ep = new EmployeePerson(ei);
//        System.out.println(ep.info.rank);

//        Person p1 = new Person("부장");
//        EmployeeInfo ei = (EmployeeInfo)p1.info; // 강제 형변환이므로 컴파일 시 에러
//        System.out.println(ei.rank);

    }
}
