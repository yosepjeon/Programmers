package Level2.가장큰정사각형찾기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int N, M;
		int[][] board;
		N = scr.nextInt();
		M = scr.nextInt();

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = scr.nextInt();
			}
		}

		Solution solution = new Solution();
		int result = solution.solution(board);

		System.out.println(result);
	}
}

class Solution {
	static boolean[][] visited;
	static boolean[] widthVisited;
	static boolean[] heightVisited;

	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int height;
	static int width;

	public int solution(int[][] board) {
		int answer = 1234;

		height = board.length;
		width = board[0].length;
		map = board;

		heightVisited = new boolean[height];
		widthVisited = new boolean[width];
		visited = new boolean[height][width];
		
		if(height == 1) {
			for(int i=0;i<width;i++) {
				if(map[0][i] == 1)
					return 1;
			}
			
			return 0;
		}
		
		if(width == 1) {
			for(int i=0;i<height;i++) {
				if(map[i][0] == 1) 
					return 1;
			}
			
			return 0;
		}

		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (map[i][j] == 1) {
					int min = Math.min(Math.min(map[i][j - 1], map[i - 1][j]), map[i - 1][j - 1]);
					min++;
					map[i][j] = min;

					if (max < min * min) {
						max = min * min;
					}
				}
			}
		}

		answer = max;

		return answer;
	}
}
