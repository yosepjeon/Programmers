package skill_check_level2.p1;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		int[] answer = solution.solution(3, words);
		System.out.println(answer[0] + ", " + answer[1]);
	}
}

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for(int i=0;i<words.length;i++) {
			int number = i%n;
			if(number == 0)
				count++;
			
			if(i != 0 && words[i].substring(0,1).equals(words[i-1].substring(words[i-1].length()-1, words[i-1].length()))) {
				answer[0] = number + 1;
				answer[1] = count;
				return answer;
			}
			
			if(map.getOrDefault(words[i], -1) == -1) {
				map.put(words[i], 1);
			}else {
				answer[0] = number + 1;
				answer[1] = count;
				return answer;
			}
		}
		
		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}
}