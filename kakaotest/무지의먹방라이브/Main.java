//package kakaotest.무지의먹방라이브;
//
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner scr = new Scanner(System.in);
//
//		int N = scr.nextInt();
//		int[] foods = new int[N];
//		int k;
//
//		System.out.println("foods");
//		for (int i = 0; i < N; i++) {
//			foods[i] = scr.nextInt();
//		}
//
//		System.out.println("k");
//		k = scr.nextInt();
//
//		Solution solution = new Solution();
//		System.out.println(solution.solution(foods, k));
//	}
//}
//
//class Solution {
//	static LinkedList<Food> foods = new LinkedList<>();
//	static LinkedList<Food> sortedFood = new LinkedList<>();
//
//	public int solution(int[] food_times, long k) {
//		int answer = 0;
//
//		long total_time = 0;
//
//		int i = 1;
//		for (int food_time : food_times) {
//			Food food = new Food(food_time, i);
//			foods.add(food);
//			sortedFood.add(food);
//			total_time += food_time;
//			i++;
//		}
//
//		if (total_time <= k) {
//			return -1;
//		}
//
//		sortedFood.sort(new Comparator<Food>() {
//
//			@Override
//			public int compare(Food o1, Food o2) {
//				// TODO Auto-generated method stub
//				if (o1.food_times > o2.food_times) {
//					return 1;
//				} else if (o1.food_times < o2.food_times) {
//					return -1;
//				} else {
//					if (o1.food_number > o2.food_number) {
//						return 1;
//					} else if (o1.food_number < o2.food_number) {
//						return -1;
//					} else {
//						return 0;
//					}
//				}
//			}
//		});
//
//		doLogic: while (k != 0) {
//			long size = foods.size();
//			long n = k/size;
//			
//			if(n > 0) {
//				
//			}else {
//				while(k!=0) {
//					
//				}
//			}
//
//		}
//
//		answer = foods.peek().food_number;
//
////		System.out.println(foods.size() + " " + sortedFood.size());
//
//		return answer;
//	}
//
//	class Food {
//		int food_times;
//		int food_number;
//
//		public Food(int food_times, int food_number) {
//			this.food_times = food_times;
//			this.food_number = food_number;
//		}
//	}
//}
//
///*
////System.out.println(minFood.food_times);
//if (k >= minFood.food_times) {
//	Food food = foods.peek();
//
//	if (food.food_number <= minFood.food_number) {
//		food.food_times -= minFood.food_times;
//		k -= minFood.food_times;
//	} else {
//		food.food_times -= (minFood.food_times - 1);
//		k -= (minFood.food_times - 1);
//	}
//
//	if (food.food_times != 0) {
//		if (food.food_number < minFood.food_number)
//			foods.add(foods.poll());
//		if(k == 0)
//			break doLogic;
//			
//	} else {
//		sortedFood.remove(food);
//		foods.poll();
//		if (k == 0)
//			break doLogic;
//	}
//
//	
//}
//if (k <= minFood.food_times) {
//	while (k != 0) {
//		Food food = foods.poll();
//
//		food.food_times--;
//		k--;
//
//		if (food.food_times != 0) {
//			foods.add(food);
//		} else {
//			sortedFood.remove(food);
//		}
//	}
//	break doLogic;
//}
//cnt++;
//*/
//
////System.out.println("k: " + k);
//
//
//// class Solution {
//// static LinkedList<Food> foods = new LinkedList<>();
//// static LinkedList<Food> sortedFood = new LinkedList<>();
//// static PriorityQueue<Food> pqFood = new PriorityQueue<>(new
//// Comparator<Food>() {
////
//// @Override
//// public int compare(Food o1, Food o2) {
//// // TODO Auto-generated method stub
//// if (o1.food_times > o2.food_times) {
//// return 1;
//// } else if (o1.food_times < o2.food_times) {
//// return -1;
//// } else {
//// if (o1.food_number > o2.food_number) {
//// return 1;
//// } else if (o1.food_number < o2.food_number) {
//// return -1;
//// } else {
//// return 0;
//// }
//// }
//// }
//// });
////
//// public int solution(int[] food_times, long k) {
//// int answer = 0;
////
//// long total_time = 0;
////
//// int i = 1;
//// for (int food_time : food_times) {
//// Food food = new Food(food_time, i);
//// foods.add(food);
//// sortedFood.add(food);
//// total_time += food_time;
//// i++;
//// }
////
//// if (total_time <= k) {
//// return -1;
//// }
////
//// sortedFood.sort(new Comparator<Food>() {
////
//// @Override
//// public int compare(Food o1, Food o2) {
//// // TODO Auto-generated method stub
//// if (o1.food_times > o2.food_times) {
//// return 1;
//// } else if (o1.food_times < o2.food_times) {
//// return -1;
//// } else {
//// if (o1.food_number > o2.food_number) {
//// return 1;
//// } else if (o1.food_number < o2.food_number) {
//// return -1;
//// } else {
//// return 0;
//// }
//// }
//// }
//// });
////
//// doLogic: while (true) {
//// if (foods.isEmpty())
//// return -1;
//// if(k == 0 )
//// break;
////
//// Food peekSortedFood = sortedFood.peek();
////// if (peekSortedFood.food_times == 0) {
////// sortedFood.poll();
////// continue;
////// }
////
//// while (true) {
//// if (foods.isEmpty())
//// return -1;
//// if (k == 0)
//// break doLogic;
////
//// Food peekFood = foods.peek();
//// peekFood.food_times--;
//// k--;
//// if (peekFood.food_number == peekSortedFood.food_number) {
////// System.out.println("****");
////// System.out.println(foods.peek().food_number);
////// System.out.println(sortedFood.peek().food_number);
////// System.out.println("____");
//// if (peekFood.food_times == 0) {
//// foods.poll();
//// sortedFood.poll();
////// System.out.println("******");
////// System.out.println(foods.size());
////// System.out.println(sortedFood.size());
////// System.out.println("-------");
//// } else {
//// System.out.println("******");
//// System.out.println(foods.peek().food_times);
//// System.out.println(sortedFood.peek().food_times);
//// System.out.println("-------");
//// foods.add(foods.poll());
//// }
//// break;
//// } else {
//// if (peekFood.food_times == 0) {
//// foods.poll();
//// sortedFood.remove(peekFood);
////
//// } else {
//// foods.poll();
//// foods.add(peekFood);
//// }
//// }
//// }
//// }
////
//// answer = foods.peek().food_number;
//// return answer;
//// }
////
//// class Food {
//// int food_times;
//// int food_number;
////
//// public Food(int food_times, int food_number) {
//// this.food_times = food_times;
//// this.food_number = food_number;
//// }
//// }
//// }
//
//// class Solution {
//// public int solution(int[] food_times, long k) {
//// int answer = 0;
////
//// Queue<Food> queue = new LinkedList<>();
//// Queue<Food> overQueue = new LinkedList<>();
////
//// int i = 1;
//// for (int food_time : food_times) {
//// queue.add(new Food(food_time, i++));
//// }
////
//// for (i = 0; i < k; i++) {
//// if (!queue.isEmpty()) {
//// Food element = queue.poll();
//// element.food_times -= 1;
//// if (element.food_times != 0)
//// queue.add(element);
//// else
//// overQueue.add(element);
//// } else {
//// return -1;
//// }
//// }
////
//// if (!queue.isEmpty()) {
//// answer = queue.peek().food_number;
//// } else {
//// return -1;
//// }
////
//// return answer;
//// }
////
//// class Food {
//// int food_times;
//// int food_number;
////
//// public Food(int food_times, int food_number) {
//// this.food_times = food_times;
//// this.food_number = food_number;
//// }
//// }
//// }
//
//// class Solution {
//// static LinkedList<Food> foods = new LinkedList<>();
////// static LinkedList<Food> sortedFood = new LinkedList<>();
//// static PriorityQueue<Food> sortedFood = new PriorityQueue<>();
////
//// public int solution(int[] food_times, long k) {
//// int answer = 0;
////
//// long total_time = 0;
////
//// int i = 1;
//// for (int food_time : food_times) {
//// Food food = new Food(food_time, i);
//// foods.add(food);
//// sortedFood.offer(food);
//// total_time += food_time;
//// i++;
//// }
////
////
//// if(total_time <= k){
//// return -1;
//// }
////
//// doLogic: while (true) {
//// if(foods.isEmpty())
//// return -1;
////
//// Food peekSortedFood = sortedFood.peek();
//// if(peekSortedFood.food_times == 0){
//// sortedFood.poll();
//// continue;
//// }
////
//// while (true) {
//// if(foods.isEmpty())
//// return -1;
//// if(k == 0)
//// break doLogic;
////
//// Food peekFood = foods.peek();
//// peekFood.food_times--;
//// k--;
//// if (peekFood.food_number == peekSortedFood.food_number) {
////
//// if (peekFood.food_times == 0) {
//// foods.poll();
//// sortedFood.poll();
//// } else {
//// Food food = foods.poll();
//// foods.add(food);
//// }
//// break;
//// } else {
//// if (peekFood.food_times == 0) {
//// foods.poll();
//// sortedFood.remove(peekFood);
//// } else {
//// Food food = foods.poll();
//// foods.add(food);
//// }
//// }
//// }
//// }
////
//// answer = foods.peek().food_number;
//// return answer;
//// }
////
//// class Food implements Comparable<Food>{
//// int food_times;
//// int food_number;
////
//// public Food(int food_times, int food_number) {
//// super();
//// this.food_times = food_times;
//// this.food_number = food_number;
//// }
////
//// @Override
//// public int compareTo(Food o) {
//// // TODO Auto-generated method stub
//// if(this.food_times > o.food_times) {
//// return 1;
//// }else if(this.food_times < o.food_times) {
//// return -1;
//// }else {
////// if(this.food_number > o.food_number) {
////// return 1;
////// }else if(this.food_number < o.food_number) {
////// return -1;
////// }else {
////// return 0;
////// }
//// return 0;
//// }
//// }
//// }
//// }
