package 식스샵.p3;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.solution(36));
	}
}

class Solution {
	public int solution(int n) {
		int answer = 0;

		int box5 = Integer.MAX_VALUE;
		int box3 = Integer.MAX_VALUE;
		int boxOther = Integer.MAX_VALUE;
		
		if(n%5 == 0) {
			return box5 = n/5;
		}

		if (n % 3 == 0) {
			box3 = n/3;
		}
		
		if(n%5 == 0) {
			box5 = n/5;
		}
		
		if((n%5)%3 == 0) {
			int num = n;
			boxOther = 0;
			boxOther += num/5;
			num %= 5;
			boxOther += num/3;
			
		}
		
		int box15= Integer.MAX_VALUE;
		if((n%15)%3 == 0) {
			int num = n;
			box15 = 0;
			box15 += num/15;
			num %= 15;
			box15 += num/3;
		}
		
		answer = Integer.min(box15, Integer.min(box5, Integer.min(box3, boxOther)));
		
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		return answer;
	}
}
