package LinkedList_basic.simpleconcept;

class Node <T> {
    T data; // 노드 내 데이터
    Node next = null;   // 다음 노드를 가지고 있어야 함.

    // 생성자에 값을 받아서 데이터에 넣음
    Node(T data) {
        this.data = data;
    }

    void append(T data) {   // 새로 넣을 데이터 값을 파라미터로 받고
        Node end = new Node(data); // 파라미터 값을 이용해서 새로 노드 생성
        Node n = this;  // 포인터 생성, 첫 번째 노드 선택

        while (n.next != null) {    // n의 다음 노드가 null이면 안됨
            n = n.next; // n이 null 아닌 마지막 값까지 돌림
        }
        // 마지막 노드
        n.next = end;   // 마지막 노드의 다음 노드 (null 부분에 end 노드 삽입)
    }

    void delete(T data) {
        Node n = this;  // 포인터 생성, 첫 번째 노드(헤더) 선택
        while (n.next != null) {
            if (n.next.data == data) {  // 다음 노드로 넘어가는 것이 아닌, 그 전에 판단
                n.next = n.next.next;   // 삭제할 노드(다음) 발견 -> 다다음 노드로 바꿈
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }   // 마지막 노드가 되기 전!에 나옴
        System.out.println(n.data);
    }

}
public class SinglyLinkedList {
    public static void main(String[] args) {
        // LList 생성
        Node<Integer> head = new Node<Integer>(1); // head 만듦
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        System.out.println();
        head.delete(2);
        head.delete(3);
        head.retrieve();


    }
}
