package Level2.구명보트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] people;
		int peopleNum = scr.nextInt();

		people = new int[peopleNum];

		for (int i = 0; i < peopleNum; i++) {
			people[i] = scr.nextInt();
		}

		int limit = scr.nextInt();

		Solution solution = new Solution();
		System.out.println(solution.solution(people, limit));
	}
}

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		
		Deque<Integer> dq = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int element : people ) {
			list.add(element);
		}
		
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 < o2) {
					return 1;
				}else if(o1 == o2) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		
		int size = list.size();
		
		for(int i=0;i<size;i++) {
			dq.add(list.get(i));
		}
		
		while(!dq.isEmpty()) {
			
			if(dq.peekFirst() + dq.peekLast() > limit || dq.size() == 1) {
//				System.out.println("!!!");
//				int element = dq.poll();
				dq.removeFirst();
				answer++;
			}else {
				dq.removeFirst();
				dq.removeLast();
				
				answer++;
			}
		}
		
		return answer;
	}
}