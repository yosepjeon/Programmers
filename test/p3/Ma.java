package test.p3;

public class Ma {

}

class Solution {
	static int[][] dp;
	static int[] value;
	
	public int solution(int n, int[][] groups) {
		int answer = 0;

		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = i == j ? 1 : 0;
			}
		}
		value=  new int[n+1];

		int len = groups.length;
		for (int num = 0; num < len; num++) {
			int i = groups[num][0];
			int j = groups[num][1];
			
			dp[i][j] = 1;
			dp[j][i] = 1;
		}
		
		answer = dfs(1,n);

		return answer;
	}
	
	public static int dfs(int start, int end) {
		if(start == end)
			return 0;
		if(dp[start][end] != 0)
			return dp[start][end];
		
		dp[start][end] = dfs(start+1,end) + 1;
		
		for(int i = start + 1;i<=end;i++) {
			 if(value[i] == value[start]){
	                dp[start][end] = Math.min((dfs(start+1, i-1) + dfs(i,end)+1), dp[start][end]);
	            }
		}
		
		return dp[start][end];
	}
}