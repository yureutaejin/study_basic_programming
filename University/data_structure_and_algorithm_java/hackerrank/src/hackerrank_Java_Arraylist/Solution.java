package hackerrank_Java_Arraylist;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        // 이차원 Arraylist 생성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // row 갯수를 지정하므로 row는 그냥 배열로 만들어주면 됨.
        int d, q, x, y;
        ArrayList[] arraylist = new ArrayList[n];   // ArrayList가 들어가야하므로 타입을 ArrayList로 지정

        for (int i = 0; i< n; i++) {
            d = sc.nextInt();

            ArrayList templist = new ArrayList();   // 가변 리스트 필요하므로 Arraylist 대입
            arraylist[i] = templist;

            for (int j = 0; j < d; j++) {
                arraylist[i].add(sc.nextInt());
            }
        }

        // query 생성

        q = sc.nextInt();
        for (int i =0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                System.out.println(arraylist[x-1].get(y-1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }


    }
}