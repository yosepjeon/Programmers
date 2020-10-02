package 식스샵.p1;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution("xyZA", "ABCxy"));
	}
}

class Solution {
	public String solution(String s1, String s2) {
		String answer = "";

		String shorter = s1.length() > s2.length() ? s2 : s1;
		String greater = s1.length() > s2.length() ? s1 : s2;
		List<String> results = new ArrayList<>();
		
		int shorterLen = shorter.length();
		int max = Integer.MIN_VALUE;
		
		for(int i=1;i<=shorterLen;i++) {
			if(shorter.substring(shorterLen-i,shorterLen).equals(greater.substring(0,i))) {
//				max = max < i ? i : max;
				if(max < i) {
					max = i;
					answer = shorter.substring(0,shorterLen-i).concat(greater);
					results.add(answer);
				}else if(max == i) {
					max = i;
					answer = shorter.substring(0,shorterLen-i).concat(greater);
					if(answer.length() >= greater.length())
						results.add(answer);
				}
			}
		}
//		System.out.println(answer + "@");
//		if(answer.length() >= greater.length())
			results.add(answer);
		
		for(int i=1;i<=shorterLen;i++) {
			if(greater.substring(shorterLen-i,shorterLen).equals(shorter.substring(0,i))) {
//				max = max < i ? i : max;
				if(max < i) {
					max = i;
					answer = greater.substring(0,shorterLen-i).concat(shorter);
					results.add(answer);
				}else if(max == i) {
					max = i;
					answer = greater.substring(0,shorterLen-i).concat(shorter);
					if(answer.length() >= greater.length())
						results.add(answer);
				}
			}
		}
//		System.out.println(answer + "@");
//		if(answer.length() >= greater.length())
			results.add(answer);
		
		results.sort((String element1,String element2) ->{
			if(element1.length() < element2.length()) {
				return -1;
			}else if(element1.length() > element2.length()) {
				return 1;
			}else {
//				return element1.compareTo(element2);
				if(element1.compareTo(element2) < 0) {
					return -1;
				}else if(element1.compareTo(element2) > 0) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
//		for(String element : results) {
//			System.out.println(element + "!");
//		}
		
		answer = results.get(0);
		Iterator<String> itr = results.iterator();
		
		while(itr.hasNext()) {
			String element = itr.next();
			
			if(element.length() < greater.length()) {
				itr.remove();
			}
		}
		
		return answer;
	}
}