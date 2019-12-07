package Level3.N으로표현;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, number, result;

		Scanner scr = new Scanner(System.in);
		N = scr.nextInt();
		number = scr.nextInt();

		Solution solution = new Solution();
		result = solution.solution(N, number);

		System.out.println(result);
	}
}

//class Solution {
//    public int solution(int N, int number) {
//        int answer = 0;
//        
//        
//        
//        return answer;
//    }
//}

class Solution {
	static int min = Integer.MAX_VALUE;
	static int result = 0;
	static int n, num;
	static String minResult;

	public int solution(int N, int number) {
		int answer = 0;
		n = N;
		num = number;

		for (int i = 0; i < 5; i++) {
			dfs(i,String.valueOf(n),1,String.valueOf(n));
		}
		
		answer = min;

		if(min >= 8)
			answer = -1;
//		System.out.println(minResult);
		return answer;
	}

	public static void dfs(int operator,String operand,int count,String result) {
		if(count > 8) {
//			System.out.println("false");
			return;
		}
		
		if (Integer.valueOf(operand) == (num)) {
//			System.out.println(operand + " vs " + num);
			if(min > count) {
				min = count;
//				minResult = result;
			}
		} else {
			switch (operator) {
			case 0:
				operand = String.valueOf(Integer.valueOf(operand) + n);
//				result += "+" + n;
				break;
			case 1:
				operand = String.valueOf(Integer.valueOf(operand) - n);
//				result += "-" + n;
				break;
			case 2:
				operand = String.valueOf(Integer.valueOf(operand) * n);
//				result += "*" + n;
				break;
			case 3:
				operand = String.valueOf(Integer.valueOf(operand) / n);
//				result += "/" + n;
				break;
			case 4:
				operand += n;
//				result += n;
//				System.out.println(operand);
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			}
			
			
			for(int i=0;i<5;i++) {
				dfs(i,operand,count+1,result);
			}
		}
	}
}