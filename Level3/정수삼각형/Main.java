package Level3.정수삼각형;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//		int[][] triangle = {{7}};
		System.out.println(solution.solution(triangle));
	}
}

class Solution {
	static int[] score;
	static int[][] dp;

	public int solution(int[][] triangle) {
		int answer = 0;
		
		if(triangle.length == 1) {
			return triangle[0][0];
		}
		
		if(triangle.length == 2) {
			return Integer.max(triangle[0][0] + triangle[1][0], triangle[0][0] + triangle[1][1] );
		}
		
		dp = new int[triangle.length][];
		for(int i=0;i<triangle.length;i++) {
			dp[i] = new int[triangle[i].length];
		}
		
		dp[0][0] = triangle[0][0];
		dp[1][0] = triangle[1][0] + triangle[0][0];
		dp[1][1] = triangle[1][1] + triangle[0][0];
		
		for(int i=2;i<triangle.length;i++) {
			dp[i][0] = dp[i-1][0] + triangle[i][0];
			dp[i][triangle[i].length-1] = dp[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
			for(int j=1;j<triangle[i].length-1;j++) {
				dp[i][j] = Integer.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
			}
		}
		
		for(int i=0;i<triangle[triangle.length-1].length;i++) {
			answer = Integer.max(answer, dp[triangle.length-1][i]);
		}
		
		return answer;
	}

	public void move(int i, int j, int[][] triangle) {
		if (i == score.length) {
			return;
		}

		if (score[i] <= score[i - 1] + triangle[i-1][j-1]) {
			score[i] = score[i-1] + triangle[i-1][j-1];
			move(i + 1, j, triangle);
			move(i + 1, j + 1, triangle);
		}else {
//			move(i + 1, j, triangle);
//			move(i + 1, j + 1, triangle);
//			return;
		}
	}
}