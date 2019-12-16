package Level2.땅따먹기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();

		int[][] land = new int[n][4];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				land[i][j] = scr.nextInt();
			}
		}

		Solution solution = new Solution();

		System.out.println(solution.solution(land));
	}
}

class Solution {
	int[][] dp;
	int[][] map;
	// boolean[] visited = new boolean[4];

	int solution(int[][] land) {
		int answer = 0;

		dp = new int[land.length][land[0].length];
		map = land;

		int col = dp.length;
		int row = dp[0].length;

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				dp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			calculate(1);
		}

//		for (int i = 0; i < col; i++) {
//			for (int j = 0; j < row; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			if (max < dp[col - 1][i])
				max = dp[col - 1][i];
		}

		return max;
	}

	void calculate(int colNum) {
//		int idx = -1;
		if (colNum >= dp.length) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			for(int j=0;j<4;j++) {
				if(i == j)
					continue;
				
				if (dp[colNum][i] < map[colNum][i] + dp[colNum - 1][j]) {
//					idx = i;
					dp[colNum][i] = map[colNum][i] + dp[colNum - 1][j];
				}
			}
			// dp[colNum][i] = Math.max(dp[colNum][i],map[colNum][i] +
			// map[colNum-1][prevIndex]);
		}

		calculate(colNum + 1);
	}
}

/*
 * 3 1 2 3 4 5 6 7 50 1 3 50 500
 */

// 기존 실패 코드 Greedy 방식
// class Solution {
// boolean[] visited = new boolean[4];
// int result = 0;
// int col;
//
// int solution(int[][] land) {
//
// col = land.length;
//
// getMaxInNotVisitedPrevRow(land, 0, -1);
//
// return result;
// }
//
// public void getMaxInNotVisitedPrevRow(int[][] land, int colNum, int
// prevMaxIdx) {
// if(colNum == col)
// return;
//
// int idx = 0;
// int max = Integer.MIN_VALUE;
//
// if(colNum == 0) {
// for (int i = 0; i < 4; i++) {
// if(max < land[0][i]) {
// max = land[0][i];
// idx = i;
// }
// }
// visited[idx] = true;
// }else {
// for(int i=0;i<4;i++) {
// if(!visited[i]&&max < land[colNum][i]) {
// max = land[colNum][i];
// idx = i;
// }
// }
// visited[prevMaxIdx] = false;
// visited[idx] = true;
// }
//
// result += max;
//
// getMaxInNotVisitedPrevRow(land, colNum+1, idx);
// }
// }
