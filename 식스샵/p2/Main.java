package 식스샵.p2;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

}

class Solution {
	public int[] solution(int[] grade) {
		int[] answer = new int[grade.length];

		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
			return n2 - n1;
		});

		for (int element : grade) {
			pq.add(element);
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int count = 1;
		while(!pq.isEmpty()) {
			int element = pq.poll();
			
			if(map.getOrDefault(element, -1) == -1) {
				map.put(element, count);
			}
			
			count++;
		}
		
		int gradeSize = grade.length;
		for(int i=0;i<gradeSize;i++) {
			answer[i] = map.get(grade[i]);
		}

		return answer;
	}
	
}