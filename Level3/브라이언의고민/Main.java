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
	public String solution(String sentence) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		
		if(sentence.contains(" "))
			return "invalid";
		
		char[] elements = sentence.toCharArray();
		
		boolean isAd = false;
		for(char element : elements ) {
			if(element >= 'a' && element <= 'z')
				isAd = true;
		}
		
		if(isAd == false)
			return "invalid";
		
		while (sentence.length() != 0) {
			String subString ="";
			
			if (sentence.charAt(0) >= 'a' && sentence.charAt(sentence.length() - 1) <= 'z') {
				char[] carr = sentence.toCharArray();
				
				int count = 0;
				for(char element : carr) {
					if(element == sentence.charAt(0))
						count++;
					
					if(count > 2)
						return "invalid";
				}
				
				int secondChar = sentence.lastIndexOf(sentence.charAt(0));
//				int secondChar = sentence.indexOf(sentence.charAt(0), sentence.indexOf(sentence.charAt(0))+1);
				if (secondChar == -1 ) {
					return "invalid";
				} else {
					subString = sentence.substring(0,secondChar+1);
					subString = subString.replace(String.valueOf(subString.charAt(0)), "");
//					sentence = sentence.replace(String.valueOf(sentence.charAt(0)), "");
					sentence = sentence.substring(secondChar+1);
				}
			}

			int rule2Index = Integer.MAX_VALUE;
			System.out.println(sb.toString());
//			System.out.println(subString);
//			if(subString.equals(""))
//				return "!";
			
			if (!subString.equals("") && subString.charAt(1) >= 'a' && subString.charAt(1) <= 'z') {
				subString = subString.replace(String.valueOf(subString.charAt(1)), "");
			}else if(subString.equals("") && sentence.charAt(1) >= 'a' && sentence.charAt(1) <= 'z') {
				subString = sentence.substring(0,sentence.lastIndexOf(sentence.charAt(1))+2);
				sentence = sentence.substring(sentence.lastIndexOf(sentence.charAt(1)) + 2);
				subString = subString.replace(String.valueOf(subString.charAt(1)), "");
			}

//			int len = subString.length();
//			for (int i = 0; i < len; i++) {
//				if(subString.charAt(i) >= 'a' && subString.charAt(i) <= 'z') {
//					return "invalid";
//				}
//			}
			
			if(subString.charAt(0) >= 'a' && subString.charAt(0)<='z') {
//				System.out.println("!");
				return "invalid";
			}
			
			if(subString.charAt(1) >= 'a' && subString.charAt(1)<='z') {
				System.out.println(subString);
				System.out.println("!");
				return "invalid";
			}
			
			sb.append(subString + " ");
		}
		
		sb.lastIndexOf(" ");
		sb.deleteCharAt(sb.lastIndexOf(" "));

		return sb.toString();
	}
}

// class Solution {
// static int rule1ResultIndex = -1;
// static int rule2ResultIndex = -1;
//
// public String solution(String sentence) {
// String answer = "";
//
//
// StringBuffer sb = new StringBuffer();
// while(sentence.length() != 0) {
// rule1ResultIndex = -1;
// rule2ResultIndex = -1;
//
//
// sentence = convertByRule1(sentence);
// if(sentence.equals("invalid")) {
// return "invalid";
// }
// System.out.println("Rule1 Result: " + sentence);
//
// sentence = convertByRule2(sentence);
// System.out.println("Rule2 Result: " + sentence);
// if(sentence.equals("invalid")) {
// return "invalid";
// }
//
// char[] elements = sentence.toCharArray();
//
// int lowerCaseIndex = -1;
// for(int i=0;i<elements.length;i++) {
//
// if(elements[i] >= 'a' && elements[i] <= 'z') {
// lowerCaseIndex = i;
// break;
// }else {
//// if(i+1 <= elements.length-1 && (elements[i+1] < 'a' || elements[i+1] >
// 'z')) {
//// System.out.println("!");
//// lowerCaseIndex = i+1;
//// break;
//// }
// }
// }
//
// if(lowerCaseIndex == -1) {
// sb.append(sentence + " ");
// break;
// }
//
// String convertedElement = sentence.substring(0,lowerCaseIndex);
// sentence = sentence.substring(lowerCaseIndex);
// sb.append(convertedElement + " ");
// System.out.println("sb: " + sb.toString());
// }
// sb.deleteCharAt(sb.lastIndexOf(" "));
//
// return sb.toString();
// }
//
// public String convertByRule1(String sentence) {
// char[] elements = sentence.toCharArray();
// if(elements.length < 3) {
// return "invalid";
// }
//
// if(elements[1] < 'a' || elements[1] > 'z') {
// return sentence;
// }
//
// if(elements[elements.length-1] == elements[1]) {
// return "invalid";
// }
//
// int prevIndex = 0;
// for(int i=1;i<elements.length;i++) {
// if(elements[1] == elements[i]) {
// if(i%2 == 0)
// return "invalid";
// }
// }
//
// rule1ResultIndex = sentence.lastIndexOf(elements[1])+1;
// System.out.println(elements[rule1ResultIndex] + "#");
// return sentence.replace(String.valueOf(elements[1]), "");
// }
//
// public String convertByRule2(String sentence) {
// char[] elements = sentence.toCharArray();
// if(elements[0] < 'a' || elements[0] > 'z') {
// return sentence;
// }
//
// if(elements.length <= 2) {
// return "invalid";
// }
//
// int count = 0;
// int length = elements.length;
// int lastElementIndex = 0;
// for(int i=0;i<length;i++) {
// if(elements[i] == elements[0]) {
// lastElementIndex = i;
// count++;
// }
// }
//
// if(count == 2 ) {
// sentence = sentence.replace(String.valueOf(elements[0]), "");
// return sentence;
// }else {
// return "invalid";
// }
//
// }
//
// class Result {
// String sentence;
// int index;
//
// public Result(String sentence, int index) {
// this.sentence = sentence;
// this.index = index;
// }
// }
// }
