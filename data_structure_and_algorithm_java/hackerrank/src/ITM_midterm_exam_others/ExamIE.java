package ITM_midterm_exam_others;

import java.util.*;

class AnswerIE implements Comparator<Action> {

	public int compare(Action a, Action b){
        if (a.todo.compareTo(b.todo) < 0){
            return 1;
        }
        else if (a.date == b.date){
            if (a.todo.compareTo(b.todo) > 0){
                return 1;
            }
        }
        return -1;
    }
	
	public String balanced(String input) {
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '}' || c==']' || c==')') {
				if(!stack.empty()) stack.pop();
				else return "No";
			}
			
			if(c == '{' || c=='[' || c=='(') {
				stack.push(String.valueOf(c));
			}
		}
		return "Yes";
	}
	
	public void isFibo(int n) {
		if(n == 1 || n == 2) {
			System.out.println("Fibo");
		}
		
		int num = 0;
		int f = 1;
		int s = 0;
		while(num < n) {
			num = f + s;
			s = f;
			f = num;
			}
		if(num == n) {
			System.out.println("Fibo");
		}
		else System.out.println("noFibo");
	}
}

class Action{
	Calendar date;
	String todo;
	public Action(int year, int month, int day, String task) {
		date = Calendar.getInstance();
		date.set(year, month-1, day);
		todo = task;
	}
	public String toString() {
		return date.get(Calendar.DATE) + "/" +(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.YEAR)+":"+todo;
	}
}

public class ExamIE {
	public static void main(String[] args) {
		Action[] todoList = new Action[2];
		AnswerIE a = new AnswerIE();
		
		todoList[0] = new Action(2021, 11, 2, "mid-term");
		todoList[1] = new Action(2021, 12, 14, "final");
		
		Arrays.sort(todoList, a);
		System.out.println(Arrays.toString(todoList));
		
		//System.out.println(a.balanced("{[()]}"));
		
		//a.isFibo(7);

	}

}
