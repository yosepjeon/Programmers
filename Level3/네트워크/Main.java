package Level3.네트워크;

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
		int result = solution.solution(n, computers);
		
		System.out.println(result);
	}
}

class Solution {
	public static int[][] hosts;
	public static boolean[][] visited;
	public static int count = 0;
	public static int size;
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        size = n;
        
        hosts = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		hosts[i][j] = computers[i][j];
        	}
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(hosts[i][j] != 0 && !visited[i][j]) {
        			count++;
        			dfs(i,j);
        		}
        	}
        }
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int i, int j) {
    	visited[i][j] = true;
    	
    	for(int index=0;index<size;index++) {
    		if(hosts[j][index] != 0 && !visited[j][index]) {
    			dfs(j,index);
    		}
    	}
    }
}