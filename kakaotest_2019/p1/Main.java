package kakaotest_2019.p1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.next();

		Solution solution = new Solution();
		int result = solution.solution(str);
		System.out.println(result);
	}
}

class Solution {
	static String min="";
	
	public int solution(String s) {
		int answer = 0;
		int len = s.length();
		String preSubStr;
		String postSubStr;
		answer = compress(s).length();
		String str = s;

		len:
		for (int i = len/2; i >= 1; i--) {
			String substr = str.substring(0,i);
			
			if(substr.compareTo(str.substring(i,2*i)) == 0) {
				
			}
		}
		String result = compress(s);

		answer = result.length();

		return answer;
	}
	
	String compress(String s) {
		String t = "";
		for (String u : s.split("(?<=(.))(?!\\1)")) {
			if (u.length() == 1) {
				t = t + u.charAt(0);
			} else {
				t = t + u.charAt(0) + u.length();
			}
		}
		return t;
	}
}
