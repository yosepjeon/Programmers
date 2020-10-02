package 짐싸.p1;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public int solution(int[] winnum, int bonus, int[] usernum) {
		int answer = 0;

		int len = winnum.length;
		for (int i = 0; i < len; i++) {
			for(int j=0;j<len;j++) {
				if(usernum[j] == -1) {
					continue;
				}
				
				if(winnum[i] == usernum[j]) {
					usernum[j] = -1;
					break;
				}
			}
		}
		
		boolean bonusHit = false;
		for(int i=0;i<len;i++) {
			if(usernum[i] == -1) {
				continue;
			}
			
			if(bonus == usernum[i]) {
				bonusHit = true;
			}
		}
		
		int count= 0;
		for(int i=0;i<len;i++) {
			if(usernum[i] == -1)
				count++;
		}
		
		System.out.println(count);
		
		if(count >= 6) {
			answer = 1;
		}else if(count == 5) {
			answer = bonusHit ? 2 : 3;
		}else if(count ==4) {
			answer = 4;
		}else if(count == 3) {
			answer = 5;
		}else {
			answer = -1;
		}
		
		
		return answer;
	}
}