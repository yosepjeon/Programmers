package kakao인턴십.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		long[] result = (solution.solution(k, room_number));
	
		for(long e : result) {
			System.out.println(e);
		}
	}
}

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        LinkedList<Long> list = new LinkedList<>();
        LinkedList<Long> copyList = new LinkedList<>();
        List<Long> result = new ArrayList<>();
        boolean[] visited = new boolean[(int) k];
        Map<Long, Long> map = new HashMap<Long, Long>();
        
        for(long i=1;i<=k;i++) {
        	list.add(i);
        	copyList.add(i);
        }
        int i=0;
        int nextIndexOf;
        for(long rn : room_number) {
        	System.out.println(rn + "!");
        	if(map.getOrDefault(rn, (long) -1) == (long)-1) {
        		result.add(rn);
        		answer[i] = rn;
        		list.remove(rn);
        		map.put(rn, rn);
        	}else {
//        		List<Long> subList = list.subList(list.indexOf(rn), toIndex);
        		long e = list.get(0);
        		result.add(e);
        		answer[i] = e;
        		list.remove(0);
        		map.put(e, e);
        	}
        	i++;
//        	if(list.contains(rn)) {
//        		result.add(rn);
//        		answer[i] = rn;
//        		list.remove(rn);
//        	}else {
//        		result.add(list.get(0));
//        		answer[i] = list.get(0);
//        		list.remove(0);
//        	}
//        	i++;
        }
        
        return answer;
    }
}
