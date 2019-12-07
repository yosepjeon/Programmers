package kakaotest_2019.p2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String p = scr.next();

		Solution solution = new Solution();
		String result = solution.solution(p);

		System.out.println(result);
	}
}

class Solution {
	public String solution(String p) {
		String answer = "";
		String[] sarr = p.split("");
		divide(sarr);

		return answer;
	}

	public String divide(String[] sarr) {
		Stack<String> stack = new Stack<>();
		int right = 0;
		int left = 0;
		String u = "";
		String v = "";
		boolean flag = false;
		int i=0;

		for (String s : sarr) {
			if (!flag) {
				if (s.equals(")")) {
					u += s;
					right++;
					i++;
					if (right == left) {
						break;
					}
				} else {
					u += s;
					left++;
					i++;
					if (right == left) {
						break;
					}
				}
			}
		}
		
		for(int num=i;num<sarr.length;num++) {
			v += sarr[i];
		}
		int len = u.length();
		if(u.substring(0, 1).equals(")") || u.substring(len-1, len).equals("(")) {
			
		}else {
//			return u + divide(v);
		}
		
		String[] varr = v.split("");
		u += divide(varr);

		return null;
	}
}
