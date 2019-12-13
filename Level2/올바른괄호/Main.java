package Level2.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String input = scr.next();

		Solution solution = new Solution();
		System.out.println(solution.solution(input));
	}
}

class Solution {
	static Stack<Character> stack = new Stack<>();

	boolean solution(String s) {
		char[] carr = s.toCharArray();
		int carrLen = carr.length;

		for (int i = 0; i < carrLen; i++) {
			if (!checkIsCorrect(carr[i]))
				return false;
		}

		if(stack.size() == 0)
			return true;
		else 
			return false;
	}

	public static boolean checkIsCorrect(char c) {
		if (c == ')') {
			if (stack.size() <= 0) {
				return false;
			}
			stack.pop();
			return true;
		} else if (c == '(') {
			stack.add('(');
			return true;
		} else {
			System.out.println(c);
			System.out.println(" ( 또는 )만 입력 가능합니다!!! ");
			return false;
		}
	}
}
