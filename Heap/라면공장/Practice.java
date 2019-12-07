package Heap.라면공장;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Practice {
	public static void main(String[] args ) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		pq.add(3);
		pq.add(2);
		pq.add(1);
		
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}
}
