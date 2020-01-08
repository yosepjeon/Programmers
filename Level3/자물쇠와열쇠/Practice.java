package Level3.자물쇠와열쇠;

import java.util.Scanner;

public class Practice {
	static int N;
	static int[][] map;
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = scr.nextInt();
			}
		}
		
		rotate();
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotate() {
		int[][] temp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j] = map[N-1-j][i];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}
