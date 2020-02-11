package Level3.등굣길;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
	}
}

class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		int[][] map = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				map[i][j] = 0;
			}
		}

		for (int[] puddle : puddles) {
			map[puddle[0]][puddle[1]] = -1;
		}

		map[1][1] = 1;
		Queue<Tile> queue = new LinkedList<>();

		return answer;
	}
	
	class Tile {
		int x,y;
		int value;
	}
}