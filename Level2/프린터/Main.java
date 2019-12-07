package Level2.프린터;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		int N = scr.nextInt();
		int[] priorities = new int[N];
		int location = -1;
		
		for(int i=0;i<N;i++) {
			priorities[i] = scr.nextInt();
		}
		location = scr.nextInt();
		
		Solution solution = new Solution();
		
		int answer = solution.solution(priorities, location);
		
		System.out.println(answer);
	}
}

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int count = 0;
		
		Queue<Element> waitQueue = new LinkedList<>();
		int index = 0;
		
		for(int priority : priorities) {
			waitQueue.add(new Element(priority,index));
			index++;
		}
		
		while(!waitQueue.isEmpty()) {
			boolean flag = true;
			Element pollValue = waitQueue.poll();
			
			for(Element priority:waitQueue) {
				if(pollValue.value < priority.value) {
					waitQueue.add(pollValue);
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				continue;
			}else {
				count++;
				if(pollValue.location == location)
					break;
			}
		}
		answer = count;
		
		return answer;
	}
	
	class Element {
		int value;
		int location;
		
		public Element(int value, int location) {
			this.value = value;
			this.location = location;
		}
	}
}
