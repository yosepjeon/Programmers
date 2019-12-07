package Level2.큰수만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


// Programmers

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String number;
		int k;
		String result;
		int n;

//		n = scr.nextInt();
		number = scr.next();
		k = scr.nextInt();

		result = solution(number, k);

		System.out.println(result);
	}

	public static String solution(String number, int k) {
		String answer = "";
		char[] carr;
		carr = number.toCharArray();
		int i;
		int removeIndex = -1;
		int num = number.length() - k; // 만들려는 수의 자리수
		char max;
		int numberLen = num + k;
		int size;
		int numCount = 0;
		
		
		size = carr.length;
		
		while(numCount != numberLen-k) {
			max = '0'-1;
			
			for(i=removeIndex+1;(size-(i+1) >= num-1);i++) {
				if(max < carr[i]) {
					max = carr[i];
					removeIndex = i;
				}
			}
			sb.append(max);
			
			numCount++;
			num -= 1;
		}
		
		answer = sb.toString();
		return answer;
	}
}

// 백준

//public class Main {
//	static StringBuilder sb = new StringBuilder();
//	static int n;
//	public static void main(String[] args) {
//		Scanner scr = new Scanner(System.in);
//		String number;
//		int k;
//		char[] result;
//
//		n = scr.nextInt();
//		k = scr.nextInt();
//		number = scr.next();
//
//		result = solution(number, k);
//		
//		for(int i=0;i<result.length;i++) {
//			System.out.print(result[i]);
//		}
////		System.out.println(result.toString());
//	}
//
//	public static char[] solution(String number, int k) {
//		String answer = "";
//		char[] carr;
//		carr = number.toCharArray();
//		int i;
//		int removeIndex = -1;
//		int num = number.length() - k; // 만들려는 수의 자리수
//		char max;
//		int numberLen = num + k;
//		int size;
//		int numCount = 0;
//		char[] result = new char[n];
//		
//		
//		size = carr.length;
//		
//		while(numCount != numberLen-k) {
//			max = '0'-1;
//			
//			for(i=removeIndex+1;(size-(i+1) >= num-1);i++) {
//				if(max < carr[i]) {
//					max = carr[i];
//					removeIndex = i;
//				}
//			}
//			result[numCount] = (max);
//			
//			numCount++;
//			num -= 1;
//		}
//		
////		answer = sb.toString();
//		return result;
//	}
//}
