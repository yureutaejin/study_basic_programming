package ITM_midterm_exam_mine;
import java.util.*;

class AnswerItm implements Comparator<Action>{
    @Override
    public int compare(Action o1, Action o2) {
        if (o1.todo != o2.todo) {
            return o1.todo.compareTo(o2.todo);
        } else {
            return o1.date.compareTo(o2.date);
        }
    }

    public String balanced(String input) {
        Stack stack = new Stack();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '}' || c==']' || c==')') {
                if(!stack.empty()) stack.pop();
                else return "No";
            }

            if(c == '{' || c=='[' || c=='(') {
                stack.push(c);
            }
        }
        return "Yes";
    }



    public void isFibo(int num) {

        int first = 1;
        int second = 1;
        int temp;

        while (second < num) {
            temp = first + second;
            first = second;
            second = temp;
        }

        if (second == num || first == num) {
            System.out.println("Fibo");
        } else {
            System.out.println("noFibo");
        }
    }
}


class Action {
    Calendar date;
    String todo;
    public Action(int year, int month, int day, String task) {
        date = Calendar.getInstance();
        date.set(year, month-1, day);
        todo = task;
    }
    public String toString() {
        return date.get(Calendar.DATE)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.YEAR) + ":"+todo;
    }
}

public class ExamITM {
    public static void main(String[] args) {
        AnswerItm a = new AnswerItm();
        // Question 1: Todo List
        Action[] todoList = new Action[2];

        todoList[0] = new Action(2021, 11, 2, "mid-term exam");
        todoList[1] = new Action(2021, 12, 14, "final exam");
        Arrays.sort(todoList, a);
        System.out.println(Arrays.toString(todoList));
        // Question 2: Balanced Bracket
        System.out.println(a.balanced("{[()]}"));
        // Question 3: Determining Fibonacci number
        a.isFibo(2);

    }
}
