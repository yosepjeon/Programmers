package Heap.라면공장;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		Solution solution = new Solution();
		int stock = 4;
		int[] dates = {4,10,5};
		int[] supplies = {20,5,10};
		int k = 30;
		
		System.out.println(solution.solution(4, dates, supplies, k));
	}
}

class Solution {
	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	});

	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		int index = 0;
		int datesSize = dates.length;

		// for (int i = 0; i < dates.length; i++) {
		// pq.add(new Element(dates[i], supplies[i]));
		// }
		
		pq.add(stock);

		while (k > 0) {
			stock = pq.poll();
			k -= stock;
			answer++;
			if (k <= 0) {
				break;
			}

			for (int i = index; i < datesSize; i++) {
				dates[i] -= stock;

				if (dates[i] <= 0) {
					index++;
					pq.add(supplies[i]);
				}
			}
		}

		return answer-1;
	}

	class Element {
		int date;
		int supply;

		public Element(int date, int supply) {
			this.date = date;
			this.supply = supply;
		}
	}
}
