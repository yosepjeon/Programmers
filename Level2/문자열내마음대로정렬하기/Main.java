package Level2.문자열내마음대로정렬하기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int N;
		String[] strarr;
		N = scr.nextInt();
		
		strarr = new String[N];
		
		for(int i=0;i<N;i++) {
			strarr[i] = scr.next();
		}
		
		Solution solution = new Solution();
	
		solution.solution(strarr, 2);
		
		for(int i=0;i<strarr.length;i++) {
			System.out.println(strarr[i]);
		}
	}
}

class Solution {
	public String[] solution(String[] strings, int n) {
		String[] answer = strings;
		
		Arrays.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				char[] c1 = o1.toCharArray();
				char[] c2 = o2.toCharArray();
				
				if(c1[n] > c2[n]) {
					return 1;
				}else if(c1[n] < c2[n]) {
					return -1;
				}else {
					if(o1.compareTo(o2) > 0) {
						return 1;
					}else if(o1.compareTo(o2) < 0) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});
		
		
		
		return answer;
	}
}