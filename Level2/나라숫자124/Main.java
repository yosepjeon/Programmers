package Level2.나라숫자124;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		Scanner scr = new Scanner(System.in);

		while (true) {
			int n = scr.nextInt();
			if(n == -1)
				break;
			System.out.println(solution.solution(n));
		}
	}
}

class Solution {
	public String solution(int n) {
		String answer = "";
		String[] result = new String[3];
		result[0] = "4";
		result[1] = "1";
		result[2] = "2";
		int rest;

		while(n>0){
			rest = n%3;
			n = n/3;
			
			if(rest == 0)
				n--;
			
			answer = result[rest] + answer;
		}

		return answer;
	}
}