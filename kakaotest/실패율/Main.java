package kakaotest.실패율;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N, stageLen;
		int[] stages;
		int[] result;

		N = scr.nextInt();
		stageLen = scr.nextInt();
		stages = new int[stageLen];

		for (int i = 0; i < stageLen; i++) {
			stages[i] = scr.nextInt();
		}

		Solution solution = new Solution();

		result = solution.solution(N, stages);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}

class Solution {
	static Map<Integer, Stage> map = new HashMap<>();
	static PriorityQueue<Stage> pq = new PriorityQueue<>(new Comparator<Stage>() {

		@Override
		public int compare(Stage o1, Stage o2) {
			// TODO Auto-generated method stub
//			double result1 = 0;
//			double result2 = 0;
//
//			if (o1.total == 0) {
//				result1 = 0;
//			}
//
//			if (o2.total == 0) {
//				result2 = 0;
//			}
//
//			if (o1.total != 0 && o2.total != 0) {
//				result1 = (double) o1.doing / (double) o1.total;
//				result2 = (double) o2.doing / (double) o2.total;
//			}

			if (o1.failPer < o2.failPer) {
				return 1;
			} else if (o1.failPer > o2.failPer) {
				return -1;
			} else {
				if (o1.stageNumber > o2.stageNumber) {
					return 1;
				} else {
					return -1;
				} 
			}
		}
	});

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		Stage s;

		for (int i = 1; i <= N; i++) {
			map.put(i, new Stage(i, 0, 0));
		}

		for (int stage : stages) {
			for (int i = 1; i <= stage; i++) {
				if (i < stage) {

					s = map.get(i);
					s.total++;

				} else {
					if (i == N + 1) {
						s = map.get(N);
					} else {

						s = map.get(i);
						s.total++;
						s.doing++;
						
//						if(i == N) {
//							System.out.println(s.stageNumber);
//						}
					}
				}
			}
		}

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			int key = itr.next();

			s = map.get(key);
			if(s.total != 0) {
				s.failPer = (double)s.doing/(double)s.total;
			}else {
				s.failPer = 0;
			}
			pq.add(s);
		}

		int count = 0;
		int size = pq.size();
		// for (Stage element : pq) {
		for (int j = 0; j < size; j++) {
			// answer[count++] = element.stageNumber;
			Stage element = pq.poll();
			System.out.print("stage: " + element.stageNumber + " ");
			System.out.print("d: " + element.doing + " ") ;
			System.out.print("t: " + element.total + " ");
			System.out.print("f: " + element.failPer + "\n");
			answer[count++] = element.stageNumber;
		}
		System.out.println();

		return answer;
	}

	class Stage {
		int stageNumber, total, doing;
		double failPer;

		public Stage(int stageNumber, int total, int doing) {
			this.stageNumber = stageNumber;
			this.total = total;
			this.doing = doing;
		}
	}
}

// 4
// 5
// 4 4 4 4 4

// 5
// 8
// 2 1 2 6 2 4 3 3

// class Solution {
// static Map<Integer, Element> map = new HashMap<>();
//
// static PriorityQueue<Element> pq = new PriorityQueue<>(new
// Comparator<Element>() {
//
// @Override
// public int compare(Element o1, Element o2) {
// // TODO Auto-generated method stub
// double result1 = (double)o1.ing / (double)o1.total;
// double result2 = (double)o2.ing / (double)o2.total;
//
// if (result1 < result2) {
// return -1;
// } else if (result1 > result2) {
// return 1;
// } else {
// if(o1.stage<o2.stage) {
// return 1;
// }else {
// return 0;
// }
// }
// }
// });
//
// public int[] solution(int N, int[] stages) {
// int[] answer = new int[N];
//
// for (int stage : stages) {
//
// for (int i = 1; i <= stage; i++) {
// if (map.getOrDefault(i, null) == null) {
//// System.out.println(i + "!");
// if (i < stage) {
// map.put(i, new Element(i, 1, 0));
// } else {
// if (i == N+1) {
// map.put(N, new Element(N, 1, 0));
// }
// if(i == stage){
//// System.out.println("!");
// map.put(i, new Element(i, 1, 1));
// }
// }
// } else {
// if (i < stage) {
//
// // map.replace(i, new
// // Element(map.get(i).total++,map.get(i).ing));
// Element element = map.get(i);
//// System.out.println("전: " + element.total);
// element.total++;
//// System.out.println("후: " + map.get(i).total);
// } else {
// if (i == N+1) {
// Element element = map.get(i - 1);
// element.total++;
// } else {
// Element element = map.get(i);
// element.total++;
// element.ing++;
// }
// }
// }
// }
// }
//
// Iterator<Integer> itr = map.keySet().iterator();
//
// while(itr.hasNext()) {
// int key = itr.next();
// System.out.println(map.get(key).stage);
// pq.add(map.get(key));
// }
//
// int count = 0;
// for(Element element: pq) {
//// System.out.println(element.stage+"!");
//// answer[count++] = element.stage;
// }
//
// return answer;
// }
//
// class Element {
// int stage;
// int total;
// int ing;
//
// public Element(int stage, int total, int ing) {
// this.stage = stage;
// this.total = total;
// this.ing = ing;
// }
// }
// }
