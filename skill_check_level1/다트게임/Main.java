package skill_check_level1.다트게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		String dartResult = scr.next();
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(dartResult));
	}
}

class Solution {
	public int solution(String dartResult) {
		char[] darts = dartResult.toCharArray();
		int dartLength = dartResult.length();
		int[] scores = new int[3];
		int cnt = -1;
		
		for (int i = 0; i < dartLength; i++) {
			if (darts[i] == '1' && darts[i + 1] == '0') {
				cnt++;
				i++;
				scores[cnt] = 10;
			}else if (darts[i] >= '0' && darts[i] <= '9') {
				cnt++;
				scores[cnt] = darts[i]-'0';
			}else if(darts[i] == 'D') {
				scores[cnt] = (int) Math.pow(scores[cnt], 2);
			}else if(darts[i] == 'T') {
				scores[cnt] = (int) Math.pow(scores[cnt], 3);
			}else if(darts[i] == '*') {
				if(cnt == 0) {
					scores[cnt] = scores[cnt]*2;
				}else {
					scores[cnt] = scores[cnt]*2;
					scores[cnt-1] = scores[cnt-1]*2;
				}
			}else if(darts[i] == '#') {
				scores[cnt] *= -1;
			}
			
		}
		
		int total = 0;
		for(int i=0;i<3;i++) {
			total += scores[i];
		}
		
		return total;
	}
}
