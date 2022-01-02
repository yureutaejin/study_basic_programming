// Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.
//
// The Player class is provided for you in your editor. It has fields: a String and a integer.
//
// Given an array of Player objects, write a comparator that sorts them in order of decreasing score;
// if or more players have the same score, sort those players alphabetically by name.
// To do this, you must create a Checker class that implements the Comparator interface,
// then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.
//
// Input Format
// Input from stdin is handled by the locked stub code in the Solution class.
// The first line contains an integer, , denoting the number of players.
// Each of the  subsequent lines contains a player's  and , respectively.
//
// Constraints
//  0 <= score <= 100
//  players can have the same name.
//  Player names consist of lowercase English letters.

// Output Format
// You are not responsible for printing any output to stdout.
// The locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.
//
// Sample Input
//      5
//      amy 100
//      david 100
//      heraldo 50
//      aakansha 75
//      aleksa 150
//
// Sample Output
//      aleksa 150
//      amy 100
//      david 100
//      aakansha 75
//      heraldo 50

package hackerrank_Java_Comparator;
import java.util.*;

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score - o1.score; // 내림차순 -> o2가 o1보다 작다고 가정 // 오름차순 -> o1가 o2보다 작다고 가정
        }
    }
}


class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

// 모범답안
//class Checker
//{
//
//    class Checker implements Comparator<Player>
//    {
//        @Override
//        public int compare(Player s1, Player s2) {
//            if (s1.score == s2.score)
//                return s2.name.compareTo(s1.name);
//            else
//                return s2.score - s1.score;
//        }
//    }
//}
