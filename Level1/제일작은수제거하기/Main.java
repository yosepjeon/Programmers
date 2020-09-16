package Level1.제일작은수제거하기;

import java.util.LinkedList;

class Solution {
	public int[] solution(int[] arr) {
		int[] answer;
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int n : arr) {
			list.add(n);
		}
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i =0 ;i<list.size();i++) {
			if(min > list.get(i)) {
				min = list.get(i);
				minIndex = i;
			}
		}
		
		list.remove(minIndex);
		answer= new int[list.size()];
		
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }else {
            for(int i = 0;i<answer.length;i++) {
			answer[i] = list.get(i);
		}   
        }
		
		
		return answer;
	}
}