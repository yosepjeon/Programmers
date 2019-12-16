package Level2.숫자의표현;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(n));

	}
}

class Solution {
	int N;
	int result = 0;
	
	public int solution(int n) {
		int answer = 0;
		N = n;
		
		for(int i=1;i<=n;i++) {
			dfs(i,i);
		}
		
		answer = result;
		
		return answer;
	}
	
	public void dfs(int num,int sum) {
		if(sum == N) {
			result++;
			return;
		}
		if(sum > N) {
			return;
		}
		
		dfs(num+1, sum + num + 1);
	}
}
