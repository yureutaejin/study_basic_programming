package hackerrank_IsFibo;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T != 0){
            long N = scan.nextLong();

            long a = 0, b = 1, temp;
            boolean isfibo = false;
            while(b<= N){
                if(b==N){
                    isfibo=true;
                    break;
                }
                temp = a + b;
                a = b;
                b = temp;
            }

            if(isfibo == true|| N == 0){
                System.out.println("IsFibo");
            }
            else
                System.out.println("IsNotFibo");

            T -= 1;
        }

    }
}
