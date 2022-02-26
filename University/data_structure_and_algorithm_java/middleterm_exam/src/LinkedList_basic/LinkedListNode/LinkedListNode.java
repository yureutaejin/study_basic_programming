package LinkedList_basic.LinkedListNode;
// 헤더를 시작으로만 사용
import java.util.*;
class LinkedList <T>{
    Node header;

    static class Node <T>{  // 노드 클래스 정의
        T data; // 노드 내 데이터
        Node next = null;
    }
    LinkedList() {
        header = new Node();    // 생성자로써 시작 시에 header을 생성
    }

    void append(T data) {   // 새로 넣을 데이터 값을 파라미터로 받고
        Node end = new Node(); // 파라미터 값을 이용해서 새로 노드 생성
        end.data = data;
        Node n = header;  // 포인터 생성, 첫 번째 노드 선택

        while (n.next != null) {    // n의 다음 노드가 null이면 안됨
            n = n.next; // n이 null 아닌 마지막 값까지 돌림
        }
        // 마지막 노드
        n.next = end;   // 마지막 노드의 다음 노드 (null 부분에 end 노드 삽입)
    }

    void delete(T data) {
        Node n = header;  // 포인터 생성, 첫 번째 노드(헤더) 선택
        while (n.next != null) {
            if (n.next.data == data) {  // 다음 노드로 넘어가는 것이 아닌, 그 전에 판단
                n.next = n.next.next;   // 삭제할 노드(다음) 발견 -> 다다음 노드로 바꿈
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next; // header 다음 부분을 n에 할당
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }   // 마지막 노드가 되기 전!에 나옴
        System.out.println(n.data);
    }

}

public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();

    }
//    private static boolean deleteNode(Node n) {
//        if (n == null || n.next == null) {
//            return false;
//        }
//        Node next = n.next;
//        n.data = next.data;
//        n.next = next.next;
//        return true;
//    }
}
