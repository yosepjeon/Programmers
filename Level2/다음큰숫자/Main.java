package Level2.다음큰숫자;

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
	public int solution(int n) {
		int answer = 0;
		
		int count = countNumberOne(n,0);
		int nextNum = n+1;
		
		while(true) {
			if(count == countNumberOne(nextNum,0)) {
				answer = nextNum;
				break;
			}
			
			nextNum++;
		}
		
		return answer;
	}
	
	public int countNumberOne(int n,int count) {
		if(n == 1) {
			return count+1;
		}
		
		if(n%2 == 0) {
			return countNumberOne(n/2,count);
		}else {
			return countNumberOne(n/2,count+1);
		}
	}
}
