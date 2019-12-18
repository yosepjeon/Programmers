package Level2.최솟값만들기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		
		
		Solution solution = new Solution();
		
		int result = solution.solution(A, B);
		
		System.out.println(result);
	}
}

class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		List<Integer> aList = new ArrayList<Integer>();
		List<Integer> bList = new ArrayList<>();
		
		for(int a : A) {
			aList.add(a);
		}
		
		for(int b : B) {
			bList.add(b);
		}
		
		Collections.sort(aList);
		Collections.sort(bList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		int sum = 0;
		int size = aList.size();
		
		for(int i=0;i<size;i++) {
			sum += aList.get(i) * bList.get(i);
		}

		return sum;
	}
}
