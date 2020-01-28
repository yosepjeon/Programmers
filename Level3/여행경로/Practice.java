package Level3.여행경로;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice {
	public static void main(String[] args ) {
//		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});
//		
//		pq.add("ATL");
//		pq.add("SFO");
//		pq.add("TTT");
//		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("a", "a");
		
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
	}
}
