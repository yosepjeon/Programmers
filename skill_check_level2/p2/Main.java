package skill_check_level2.p2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] phone_book = {"119","97674223","1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
		
		System.out.println(solution.solution(phone_book));
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book, (String s1, String s2) -> {
			if(s1.length() < s2.length()) {
				return -1;
			}else if(s1.length() > s2.length()) {
				return 1;
			}else {
				return 0;
			}
		});
		
		
		for (int i = 0; i < phone_book.length; i++) {
			for(int j=i+1;j<phone_book.length;j++) {
				if(phone_book[i].equals(phone_book[j].substring(0,phone_book[i].length()))) {
					return false;
				}
			}
		}

		return answer;
	}
}