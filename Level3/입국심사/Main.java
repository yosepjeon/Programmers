package Level3.입국심사;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		Solution solution = new Solution();
		int[] times = {7,10};

		System.out.println(solution.solution(6, times));
	}
}

class Solution {
	public long solution(int n, int[] times) {
		long answer = 0;

		List<Integer> timeList = new ArrayList<>();

		long timeSize = times.length;
		long right = 0;
		for (int i = 0; i < timeSize; i++) {
			if(right < times[i])
				right = times[i];
			timeList.add(times[i]);
		}
//		timeList.sort((n1, n2) -> n1 - n2);

		answer = findValue(timeList, 1, n * right, n);

		return answer;
	}
	
	public long findValue(List<Integer> timeList, long left, long right, long people) {
		long min = left;
		long max = right;
		long answer=Long.MAX_VALUE;
		
		while(min <= max) {
			long sum = 0;
			
			long mid = (min + max)/2;
			
			for(int time : timeList) {
				sum += mid/time;
			}
//			System.out.println(sum);
			
			if(sum < people) {
				min = mid + 1;
			}else {
				if(mid < answer) 
					answer = mid;
				max = mid-1;
			}
		}
		
		return answer;
	}
}
//	public long findValue(List<Integer> timeList, long firstValue, long left, long right, long people) {
//		long value = firstValue * right;
//		BigInteger result = BigInteger.valueOf(value);
//		System.out.println("left: " + left + " right: " + right + " value: " + value);
//		long count = right;
//		long total = value;
////		System.out.println("count: " + count);
//		long mid = (left + right)/2;
//		if(right == left) {
////			System.out.println("*****left: " + left + " right: " + right + " value: " + value);
//		}
//		
//		if(left > right)
//			return mid;
//
//		for (int element : timeList) {
////			System.out.println(element + "!");
////			long person = value == 0 ? value / element : value++;
//			long person = value/element;
////			System.out.println("person: " + person);
//			count += person;
//			total += element * person;
//			if (count > people) {
//				return findValue(timeList, firstValue, left, mid-1, people);
//			} else if (count < people) {
//				return findValue(timeList, firstValue, mid+1, right, people);
//			}else if(left >= right){
//				return mid;
//			}
//
////			total += element * person;
////			 System.out.println("total: " + total);
//		}
//
//		return value;
//	}


//2, {1,2,2,2,100}
//6, {7,10}
