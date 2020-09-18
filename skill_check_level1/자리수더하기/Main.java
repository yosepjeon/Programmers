package skill_check_level1.자리수더하기;

public class Main {

}

class Solution {
	public int solution(int n) {
		int answer = 0;

		String s = String.valueOf(n);
		char[] carr = s.toCharArray();
		
		for (char element : carr) {
			answer += element - '0';
		}

		return answer;
	}
}
