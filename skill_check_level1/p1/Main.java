package skill_check_level1.p1;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.solution(16));
	}
}

class Solution {
	public int solution(int num) {
		int answer = 0;
		int count = 0;
		while (num != 1) {
			if(count == 500) {
				return -1;
			}
			if (num % 2 == 0) {
				num /= 2;
			} else if(num % 2 == 1){
				num = num * 3;
				num += 1;
			}
			count++;
		}

		answer = count;

		return answer;
	}
}
