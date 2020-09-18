package Level3.브라이언의고민;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		Solution solution = new Solution();

		String sentence = scr.next();
		System.out.println(solution.solution(sentence));
	}
}

class Solution {
	static int rule1ResultIndex = -1;
	static int rule2ResultIndex = -1;
	
	public String solution(String sentence) {
		String answer = "";
		
		
		StringBuffer sb = new StringBuffer();
		while(sentence.length() != 0) {
			rule1ResultIndex = -1;
			rule2ResultIndex = -1;
			
			
			sentence = convertByRule1(sentence);
			if(sentence.equals("invalid")) {
				return "invalid";
			}
			System.out.println("Rule1 Result: " + sentence);
			
			sentence = convertByRule2(sentence);
			System.out.println("Rule2 Result: " + sentence);
			if(sentence.equals("invalid")) {
				return "invalid";
			}
			
			char[] elements = sentence.toCharArray();
			
			int lowerCaseIndex = -1;
			for(int i=0;i<elements.length;i++) {
				
				if(elements[i] >= 'a' && elements[i] <= 'z') {
					lowerCaseIndex = i;
					break;
				}else {
//					if(i+1 <= elements.length-1 && (elements[i+1] < 'a' || elements[i+1] > 'z')) {
//						System.out.println("!");
//						lowerCaseIndex = i+1;
//						break;
//					}
				}
			}
			
			if(lowerCaseIndex == -1) {
				sb.append(sentence + " ");
				break;
			}
			
			String convertedElement = sentence.substring(0,lowerCaseIndex);
			sentence = sentence.substring(lowerCaseIndex);
			sb.append(convertedElement + " ");
			System.out.println("sb: " + sb.toString());
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));

		return sb.toString();
	}
	
	public String convertByRule1(String sentence) {
		char[] elements = sentence.toCharArray();
		if(elements.length < 3) {
			return "invalid";
		}
		
		if(elements[1] < 'a' || elements[1] > 'z') {
			return sentence;
		}
		
		if(elements[elements.length-1] == elements[1]) {
			return "invalid";
		}
		
		int prevIndex = 0;
		for(int i=1;i<elements.length;i++) {
			if(elements[1] == elements[i]) {
				if(i%2 == 0)
					return "invalid";
			}
		}
		
		rule1ResultIndex = sentence.lastIndexOf(elements[1])+1;
		System.out.println(elements[rule1ResultIndex] + "#");
		return sentence.replace(String.valueOf(elements[1]), "");
	}

	public String convertByRule2(String sentence) {
		char[] elements = sentence.toCharArray();
		if(elements[0] < 'a' || elements[0] > 'z') {
			return sentence;
		}
		
		if(elements.length <= 2) {
			return "invalid";
		}
		
		int count = 0;
		int length = elements.length;
		int lastElementIndex = 0;
		for(int i=0;i<length;i++) {
			if(elements[i] == elements[0]) {
				lastElementIndex = i;
				count++;
			}
		}
			
		if(count == 2 ) {
			sentence = sentence.replace(String.valueOf(elements[0]), "");
			return sentence;
		}else {
			return "invalid";
		}
		
	}
	
	class Result {
		String sentence;
		int index;
		
		public Result(String sentence, int index) {
			this.sentence = sentence;
			this.index = index;
		}
	}
}
