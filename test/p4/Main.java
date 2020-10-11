package test.p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		String[] votes = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(votes, 2));
	}
}

class Solution {
	public String solution(String[] votes, int k) {
		String answer = "";

		Map<String, Integer> cars = new HashMap<String, Integer>();

		for (String element : votes) {
			if(cars.getOrDefault(element, -1) == -1) {
				cars.put(element, 1);
			}else {
				int count = cars.get(element);
				
				cars.replace(element, count+1);
			}
		}
		
//		PriorityQueue<Car> pq = new PriorityQueue<>((car1, car2) -> {
//			if(car1.count > car2.count) {
//				return 1;
//			}else if(car1.count < car2.count) {
//				return -1;
//			}else {
//				if(car1.name.compareTo(car2.name) < 0) {
//					return 1;
//				}else if (car1.name.compareTo(car2.name) > 0) {
//					return -1;
//				}else {
//					return 0;
//				}
//			}
//		});
//		
//		Iterator<String> itr = cars.keySet().iterator();
//		
//		while(itr.hasNext()) {
//			String key = itr.next();
//			int count = cars.get(key);
//			
//			pq.add(new Car(key,count));
//		}
		
//		int count = 0;
//		int voteSize = votes.length;
//		String name = "";
//		while(!pq.isEmpty() || count < voteSize) {
//			if(pq.isEmpty())
//				break;
//			
//			Car car = pq.peek();
//			if(count+car.count < voteSize) {
//				count += car.count;
//				name = car.name;
//				pq.poll();
//			}else {
//				break;
//			}
//		}
		
		List<Car> carList = new ArrayList<>();
		
		Iterator<String> itr = cars.keySet().iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			int count = cars.get(key);
			
			carList.add(new Car(key,count));
		}
		
		carList.sort((car1, car2) -> {
			if(car1.count > car2.count) {
				return 1;
			}else if(car1.count < car2.count) {
				return -1;
			}else {
				if(car1.name.compareTo(car2.name) < 0) {
					return 1;
				}else if (car1.name.compareTo(car2.name) > 0) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		int carListSize = carList.size();
		int max = 0;
		for(int i = carListSize-1;i != (carListSize-1)-k;i--) {
			max += carList.get(i).count;
		}
		
		String name = "";
		int count = 0;
		for(Car car : carList) {
			if(count + car.count < max) {
				name = car.name;
				count += car.count;
			}else {
				break;
			}
		}

		answer = name;
		return answer;
	}
	
	class Car {
		String name;
		int count;
		
		public Car(String name, int count) {
			this.name = name;
			this.count = count;
		}
	}
}
