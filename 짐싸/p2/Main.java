package 짐싸.p2;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
//		System.out.println(solution.solution(35));
		System.out.println(solution.solution(Integer.MAX_VALUE-1));
	}
}

class Solution {
	public int solution(int n) {
		int answer = 1;

		answer = findFactorialTail(n);
		
		return answer;
	}

	public int findFactorialTail(int num) {
		int count1 = 0;
		double p = 1.0;
		while(num>p) {
			p *= 5;
			count1 += Math.floor(num/p);
		}
		
		return count1;
		
//		int count2 = 0;
//		
//		count2 += num / 5;
//		
//		if(num / 25 >= 1) {
//			count2 += (num / 25);
//		}
//		
//		System.out.println(count1 + ", " + count2);
//		return -1;
		
//		return count2;
	}
}