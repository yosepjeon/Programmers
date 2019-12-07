package Level3.브라이언의고민;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String sentence = scr.next();
		
		Solution solution = new Solution();
		System.out.println(solution.solution(sentence));
	}
}

class Solution {
	public int solution(String sentence) {
		int answer=0;
		
		return answer;
	}
}

//class Solution {
//	static String answer ="";
//	
//	public String solution(String sentence) {
//		if(!checkSpace(sentence)) {
//			return "invalid";
//		}
//		
//		run(sentence);
//		
//		return "";
//	}
//	
//	private void run(String sentence) {
//		String firstChar = getFirstChar(sentence);
//		String str = sentence;
//		
//		int firstIndex = str.indexOf(firstChar);
//		int lastIndex = str.lastIndexOf(firstChar);
//		
//		if(firstIndex == 0) {
//			
//		}else {
//			
//		}
//	}
//	
//	private boolean checkSpace(String sentence) {
//		int indexOf = sentence.indexOf(" ");
//		
//		if(indexOf != -1) {
//			return false;
//		}else {
//			return true;
//		}
//	}
//	
//	private String getFirstChar(String sentence) {
//		int sentenceLen = sentence.length();
//		
//		for(int i=0;i<sentenceLen;i++) {
//			if(Integer.valueOf(sentence.substring(i,i+1))>=97 && Integer.valueOf(sentence.substring(i,i+1))<=122) {
//				return sentence.substring(i,i+1);
//			}
//		}
//		
//		return null;
//	}
//	
//	private String getLastChar(String sentence) {
//		int sentenceLen = sentence.length();
//		
//		for(int i=sentenceLen-1;i>=0;i--) {
//			if(Integer.valueOf(sentence.substring(i,i-1))>=97 && Integer.valueOf(sentence.substring(i,i-1))<=122) {
//				return sentence.substring(i,i-1);
//			}
//		}
//		
//		return null;
//	}
//	
//	private String Rule1(String sentence, String firstChar) {
//		
//		
//		return null;
//	}
//	
//	private String Rule2(String sentence, String firstChar) {
//		int index;
//		int lastIndex = sentence.lastIndexOf(firstChar);
//		
//		while((index = sentence.indexOf(firstChar)) != -1) {
//			if(index == sentence.lastIndexOf(firstChar))
//				break;
//			if(index+1 == sentence.indexOf(firstChar, index))
//				return "invalid";
//		}
//		
//		index = sentence.indexOf(firstChar);
//		String subString = sentence.substring(index+1,lastIndex);
//		for(int i = index+1;i<lastIndex;i++) {
//			if(!getFirstChar(subString).equals(getLastChar(subString)))
//				return "invalid";
//		}
//		
//		return null;
//	}
//}
