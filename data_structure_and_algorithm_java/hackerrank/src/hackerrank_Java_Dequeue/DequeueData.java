package hackerrank_Java_Dequeue;
import java.util.*;
public class DequeueData {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set set = new HashSet<>();
        int max = 0;
        for(int i=0; i<n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if( i < m-1 ) continue;
            int size = set.size();
            if( size > max ) max = size;
            int removed = (Integer) deque.remove();
            if( !deque.contains(removed) ) {
                set.remove(removed);
            }
        }
        System.out.println(max);
    }
}