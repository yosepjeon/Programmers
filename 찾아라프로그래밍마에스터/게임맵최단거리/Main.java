package 찾아라프로그래밍마에스터.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
	
		int n,m;
		int[][] maps;
		
		n = scr.nextInt();
		m = scr.nextInt();
		
		maps = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				maps[i][j] = scr.nextInt();
			}
		}
		
		Solution solution = new Solution();
		int result = solution.solution(maps);
		
		System.out.println(result);
	}
}

class Solution {
	static boolean[][] visited;
	static int[][] map;
	static int height,width;
	static int min = Integer.MAX_VALUE;
	
	public int solution(int[][] maps) {
		int answer = 0;
		height = maps.length;
		width = maps[0].length;
		map = maps;
		visited = new boolean[height][width];
		
		dfs(0,0);
		
		answer = min;
		
		return answer;
	}
	
	public void dfs(int y, int x) {
		Queue<Element> queue = new LinkedList<>();
		boolean isArriveGoal = false;
		queue.add(new Element(y,x,1));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Element element = queue.poll();
			
			if(element.y == height-1 && element.x == width-1) {
				isArriveGoal = true;
				if(min > element.count) {
					min = element.count;
				}
			}
			
			// 상
			if(element.y-1 >= 0 && map[element.y-1][element.x] == 1 && !visited[element.y-1][element.x]) {
				queue.add(new Element(element.y-1,element.x,element.count+1));
				visited[element.y-1][element.x] = true;
			}
			
			// 하
			if(element.y+1 < height && map[element.y+1][element.x] == 1 && !visited[element.y+1][element.x]) {
				queue.add(new Element(element.y+1,element.x,element.count+1));
				visited[element.y+1][element.x] = true;
			}
			
			// 좌
			if(element.x-1 >= 0 && map[element.y][element.x-1] == 1 && !visited[element.y][element.x-1]) {
				queue.add(new Element(element.y,element.x-1,element.count+1));
				visited[element.y][element.x-1] = true;
			}
			
			// 우
			if(element.x+1 < width && map[element.y][element.x+1] == 1 && !visited[element.y][element.x+1]) {
				queue.add(new Element(element.y,element.x+1,element.count+1));
				visited[element.y][element.x+1] = true;
			}
		}
		
		if(!isArriveGoal) {
			min = -1;
		}
	}
	
	class Element {
		int x,y;
		int count;
		
		public Element(int y,int x, int count){
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}