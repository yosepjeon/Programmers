package Level5.자동완성;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] words;
		int size;

		Scanner scr = new Scanner(System.in);
		size = scr.nextInt();
		scr.nextLine();
		words = new String[size];

		for (int i = 0; i < size; i++) {
			words[i] = scr.next();
		}

		Solution solution = new Solution();
		System.out.println(solution.solution(words));
	}
}

class Solution {
	static int total = 0;
	static List<Element> list = new ArrayList<>();

	public int solution(String[] words) {
		int answer = 0;

		for (String word : words) {
			list.add(new Element(word));
		}

		Collections.sort(list, new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o1.word.compareTo(o2.word);
			}
		});
		
		for(Element element : list) {
			System.out.print(element.word + " ");
		}
		
		System.out.println();

		if (list.size() == 1) {
			answer = 1;
		} else {
			for (int i = 0; i <= list.size() - 1; i++) {
				// System.out.println(i + "번째");
				if(i == list.size()-1) {
					list.get(i).index = 1;
					list.get(i).isEqual = false;
					list.get(i-1).index = 1;
					list.get(i-1).isEqual = false;
				}
				checkEqual(i);
			}
		}
		// System.out.println("***" + list.get(list.size()-1).index);
//		if (!list.get(list.size() - 1).isEqual)
//			answer = total + list.get(list.size() - 1).index;
//		else
//			answer = total + list.get(list.size() - 1).index + 1;
		
		answer = total;
		return answer;
	}

	public static void checkLast(int index) {

	}

	public static void checkEqual(int index) {
		Element element1, element2;

		if (index < list.size() - 1) {
			element1 = list.get(index);
			element2 = list.get(index + 1);
		} else {
			element1 = list.get(index);
//			element1.index = 1;
			element2 = list.get(index - 1);
//			element2.index = 1;
//			System.out.println("last!");
//			System.out.println(element1.word);
//			System.out.println(element2.word);
//			System.out.println(element1.index + "!");
		}

		if (element1.index == element1.word.length()) {

//			System.out.println("!");
//			System.out.println(element1.index);
			System.out.println(element1.word.substring(0,element1.index));
			total += element1.index;
//			System.out.println(total + "!!");
			return;
		}

		if (element1.index < element2.word.length()) {
			if (element1.word.substring(0, element1.index).equals(element2.word.substring(0, element1.index))) {
				element1.index++;
				element2.index = element1.index;
				element2.isEqual = true;
				checkEqual(index);
			} else {
//				System.out.println("@");
//				 System.out.println(element1.index);
				if (element1.isEqual) {
					System.out.println(element1.word.substring(0,element1.index+1));
					total += (element1.index + 1);
//					System.out.println(total + "!");
				} else {
					System.out.println(element1.word.substring(0,element1.index));
					total += element1.index;
				}
				return;
			}
		} else {
//			System.out.println("#");
//			System.out.println(element1.word);
//			System.out.println(element2.word);
			element2.index = element1.index;
			System.out.println(element1.word.substring(0,element1.index));
			total += element1.index;
			return;
		}

	}

	class Element {
		boolean isEqual;
		int index;
		String word;

		public Element(String word) {
			this.word = word;
			this.index = 1;
			this.isEqual = false;
		}

	}
}
