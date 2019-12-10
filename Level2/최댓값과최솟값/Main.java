package Level2.최댓값과최솟값;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String s = scr.nextLine();

		Solution solution = new Solution();

		System.out.println(solution.solution(s));
	}
}

class Solution {
	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;

	public String solution(String s) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int idx;
//		System.out.println(s.indexOf(" ") + "!");
		while ((idx = s.indexOf(" ")) != -1) {
			minValue = Math.min(Integer.valueOf(s.substring(0, idx)), minValue);
			maxValue = Math.max(Integer.valueOf(s.substring(0, idx)), maxValue);
			s = s.substring(idx+1, s.length());
		}
		minValue = Math.min(Integer.valueOf(s.substring(0, s.length())), minValue);
		maxValue = Math.max(Integer.valueOf(s.substring(0, s.length())), maxValue);
		
		answer += minValue;
		answer += " ";
		answer += maxValue;

		return answer;
	}
}