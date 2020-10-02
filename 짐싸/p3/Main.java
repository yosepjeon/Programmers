package 짐싸.p3;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("aaaac"));
	}
}

class Solution {
	public int solution(String plain) {
		int answer = 0;
		String reversePlain = new StringBuffer(plain).reverse().toString();


		int len = plain.length();
		int[][] dp = new int[len+1][len+1];
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(plain.charAt(i) == reversePlain.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
				}else {
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		answer = len + (len - dp[len][len]);

		return answer;
	}
}