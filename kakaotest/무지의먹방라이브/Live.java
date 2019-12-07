package kakaotest.무지의먹방라이브;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Live {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int N = scr.nextInt();
		int[] foods = new int[N];
		int k;

		System.out.println("foods");
		for (int i = 0; i < N; i++) {
			foods[i] = scr.nextInt();
		}

		System.out.println("k");
		k = scr.nextInt();

		Solution solution = new Solution();
		System.out.println(solution.solution(foods, k));
	}
}

class Solution {
	static Queue<Food> pq = new PriorityQueue<>(new Comparator<Food>() {

		@Override
		public int compare(Food o1, Food o2) {
			// TODO Auto-generated method stub
			if(o1.count > o2.count) {
				return 1;
			}else if(o1.count == o2.count){
				if(o1.food_num > o2.count) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return -1;
			}
		}
	});
	static Queue<Food> foods = new LinkedList<>();

	public int solution(int[] food_times, long k) {
		int answer = 0;
		long network_time = 0;

		int num = 1;
		for (int element : food_times) {
			Food food = new Food(num++,element);
			pq.add(food);
			foods.add(food);
		}
		
//		Iterator<Food> it = pq.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next().count);
//		}
		
		int size = pq.size();
		while (true) {
			if(network_time == k)
				break;
			int e = pq.peek().count;
			if(k/size >= pq.peek().count) {
				
				for(int i=0;i<size;i++) {
					Food f = pq.peek();
					f.count -= e;
					network_time += e;
					if(f.count == 0) {
						foods.remove(f);
						pq.poll();
					}
				}
				continue;
			}else {
				break;
			}
		}
		
//		Queue<Food> queue = new LinkedList<Food>();
//		Iterator<Food> itr = pq.iterator();
//		
//		while(itr.hasNext()) {
//			Food food = itr.next();
//			queue.add(food);
//		}
		
		while(true) {
			if(network_time == k)
				break;
			if(network_time != k && foods.isEmpty())
				return -1;
			
			Food food = foods.peek();
			food.count--;
			network_time++;
			
			if(food.count == 0) {
				foods.poll();
			}else {
				foods.poll();
				foods.add(food);
			}
		}
		if(foods.size() ==0)
			return -1;
		
		answer = foods.peek().food_num;

		return answer;
	}

	class Food {
		int food_num;
		int count;

		public Food(int food_num, int count) {
			this.food_num = food_num;
			this.count = count;
		}
	}
}
