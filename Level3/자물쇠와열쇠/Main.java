package Level3.자물쇠와열쇠;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int M, N;
		int[][] key;
		int[][] lock;

		M = scr.nextInt();
		key = new int[M][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				key[i][j] = scr.nextInt();
			}
		}

		N = scr.nextInt();
		lock = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lock[i][j] = scr.nextInt();
			}
		}

		Solution solution = new Solution();

		System.out.println(solution.solution(key, lock));
	}
}

class Solution {
	int circleCount = 0;
	int upCount = 0;
	int downCount = 0;
	int leftCount = 0;
	int rightCount = 0;
	int[][] globalKey;
	int[][] globalLock;

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;

		globalKey = key;
		globalLock = lock;
		
		return answer;
	}

	public void rotate() {
		int M = globalKey.length;
		int[][] tempMap = new int[M][M];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				tempMap[i][j] = globalKey[M-1-j][i];
//				globalKey[i][j] = 
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				globalKey[i][j] = tempMap[i][j];
			}
		}
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
}
