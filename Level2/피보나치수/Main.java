package Level2.피보나치수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n = scr.nextInt();
		
		Solution solution = new Solution();
		System.out.println(solution.solution(n));
	}
}

class Solution {
	int[] dp;
	
	public int solution(int n) {
		int answer = 0;
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		if(n == 1) {
			answer = 1;
		}else {
			pibo(2,dp[0],dp[1],n);
		}
		
		answer = dp[n];
		
		return answer;
	}
	
	public void pibo(int k,int dp1,int dp2,int num) {
		dp[k] = (dp1 + dp2) % 1234567;
		if(k == num) {
			return;
		}
		
		pibo(k+1,dp2,dp[k],num);
	}
}
