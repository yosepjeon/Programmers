package Level2.가장큰수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int N = scr.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = scr.nextInt();
		}

		Solution solution = new Solution();
		System.out.println(solution.solution(numbers));
	}
}

class Solution {
	static ArrayList<Integer> list = new ArrayList<>();

	public String solution(int[] numbers) {
		String answer = "";
		StringBuffer sb = new StringBuffer();

		for (int number : numbers) {
			list.add(number);
		}

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(o1) + String.valueOf(o2);
				String s2 = String.valueOf(o2) + String.valueOf(o1);

				if (Integer.valueOf(s1) > Integer.valueOf(s2)) {
					s1 = null;
					s2 = null;
					return -1;
				} else if (Integer.valueOf(s1) < Integer.valueOf(s1)) {
					s1 = null;
					s2 = null;
					return 1;
				} else {
					s1 = null;
					s2 = null;
					return 0;
				}
			}
		});
		
		for(int element : list) {
			sb.append(element);
		}

		return sb.toString();
	}
}


// 이게 정답입!!!!
//class Solution {
//	static ArrayList<Integer> list = new ArrayList<>();
//
//	public String solution(int[] numbers) {
//		String answer = "";
//		String[] numbersString = new String[numbers.length];
//		StringBuffer sb = new StringBuffer();
//		
//		int i=0;
//		for (int number : numbers) {
//			numbersString[i++] = String.valueOf(number);
//		}
//
//		Arrays.sort(numbersString, (o1,o2)->(o2+o1).compareTo((o1+o2)));
//		
//		if(numbersString[0].equals("0"))
//			return "0";
//		
//		for(String element : numbersString) {
//			sb.append(element);
//		}
//
//		return sb.toString();
//	}
//}