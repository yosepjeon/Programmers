package Level1.자연수뒤집어배열만들기;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.solution(54321));
	}
}

class Solution {
	public int[] solution(long n) {
		int[] answer;

		String str = String.valueOf(n);
		char[] carr = str.toCharArray();
		
		answer = new int[carr.length];
		for (int i = carr.length-1; i >= 0; i--) {
			answer[carr.length-1 - i] = carr[i] - '0';
		}
		//
		return answer;
	}
}
