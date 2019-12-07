package Level2.joystick;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String name = scr.next();
		Solution solution = new Solution();

		int answer = solution.solution(name);

		System.out.println(answer);
	}
}

class Solution {
	static LinkedList<Element> queue;
	static Element curElement;

	public int solution(String name) {
		int answer = 0;
		char[] carr;
		int min = Integer.MAX_VALUE;
		int min_index;
		int total = 0;
		carr = name.toCharArray();
		queue = new LinkedList<>();

		int index = 0;
		for (char c : carr) {
			if (index == 0) {
				curElement = new Element(c,0);
//				queue.add(new Element(c, index));
			} else {
				if (c != 'A') {
					queue.add(new Element(c, index));
				}
			}

			index++;
		}

		while (!queue.isEmpty()) {
				int value1 = Math.abs(curElement.c - 'A'); // 오른쪽으로 이동
				int value2 = Math.abs(26-value1); // 왼쪽으로 이동
				
				if(value1 < value2) { // 위쪽으로 이동
					total += value1;
				}else { // 아래쪽으로 이동
					total += value2;
				}
				
				index = 0;
				min = Integer.MAX_VALUE;
				min_index = -1;
				Element minElem = null;
				for (Element element : queue) {
					value1 = Math.abs(curElement.index - element.index);
					value2 = Math.abs(carr.length - value1);
					int lessValue;
					if(value1 < value2) {
						lessValue = value1;
					}else {
						lessValue = value2;
					}
					
					if(min > lessValue) {
						min = lessValue;
						min_index = index;
						minElem = element;
					}
					
					index++;
				}
				
				curElement = queue.get(min_index);
				total += min;

				queue.remove(min_index);

		}
		
		int value1 = Math.abs(curElement.c - 'A'); // 오른쪽으로 이동
		int value2 = Math.abs(26-value1); // 왼쪽으로 이동
		
		if(value1 < value2) { // 위쪽으로 이동
			total += value1;
		}else { // 아래쪽으로 이동
			total += value2;
		}
		
		answer = total;

		return answer;
	}

	public static void changeStart() {

	}

	class Element {
		char c;
		int index;

		public Element(char c, int index) {
			this.c = c;
			this.index = index;
		}
	}
}
