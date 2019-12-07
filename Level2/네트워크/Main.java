package Level2.네트워크;

import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int n;
		int[][] computers;
		
		n = scr.nextInt();
		computers = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				computers[i][j] = scr.nextInt();
			}
		}
		
		Solution solution = new Solution();
		solution.solution(n, computers);
	}
}

class Solution {
	static boolean[] visited;
	static int count =0;

	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(computers[i][j] == 1 && !visited[j]) {
        			count++;
        			dfs(i,j);
        		}
        	}
        }
        
        return answer;
    }
    
    public void dfs(int i,int j) {
    	visited[j] = true;
    }
}
