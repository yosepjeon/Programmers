package Level2.다리를지나는트럭;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int bridge_len;
	static Queue<Truck> bridge = new LinkedList<>();

	public static void main(String[] arsgs) {
		int bridge_length, weight;
		int[] truck_weights;
		int N;
		int result=0;

		Scanner scr = new Scanner(System.in);
		N = scr.nextInt();
		bridge_length = scr.nextInt();
		weight = scr.nextInt();

//		N = scr.nextInt();
		truck_weights = new int[N];

		for (int i = 0; i < N; i++) {
			truck_weights[i] = scr.nextInt();
		}

		result = solution(bridge_length, weight, truck_weights);

		System.out.println(result);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int trucks_len = truck_weights.length;
		int i = 0;
		int bridge_weight = weight;
		Queue<Truck> trucks = new LinkedList<>();

		for (i = 0; i < trucks_len; i++) {
			// System.out.println(truck_weights[i]);
			trucks.add(new Truck(0, truck_weights[i]));
		}

//		bridge_weight -= trucks.peek().weight;
//		bridge.add(trucks.poll());
//		
//		while(!bridge.isEmpty()) {
//			
//		}
		
		while (true) {
			if (trucks.isEmpty() && bridge.isEmpty()) {
				break;
			} else {
//				answer++;
				if (!bridge.isEmpty() && bridge.peek().curPlace == bridge_length) {
					// System.out.println(bridge.peek().curPlace);
					Truck pollbridge = bridge.poll();
//					System.out.println(answer + " : " + pollbridge.weight);
					bridge_weight += pollbridge.weight;

					for(Truck truck : bridge) {
						truck.curPlace += 1;
					}

				}
				
				// System.out.println("truck[i]: " + trucks[i].weight);
				if (!trucks.isEmpty() && bridge_weight - trucks.peek().weight >= 0) {
					Truck pollTruck = trucks.poll();
					bridge_weight -= pollTruck.weight;
					// trucks[i].curPlace += 1;

					
					for(Truck truck : bridge) {
						truck.curPlace += 1;
					}
					
					pollTruck.curPlace += 1;
					
					bridge.add(pollTruck);
					
					if(!bridge.isEmpty() && bridge.peek().curPlace == bridge_length) {
						Truck pollbridge = bridge.poll();
//						System.out.println(answer + " : " + pollbridge.weight);
						bridge_weight += pollbridge.weight;
					}
				} else {
					for(Truck truck : bridge) {
						truck.curPlace += 1;
					}
					
					if(!bridge.isEmpty() && bridge.peek().curPlace == bridge_length) {
						Truck pollbridge = bridge.poll();
//						System.out.println(answer + " : " + pollbridge.weight);
						bridge_weight += pollbridge.weight;
					}
				}

				answer++;
			}
		}

		return answer+1;
	}
}

class Truck {
	int curPlace;
	int weight;

	public Truck(int curPlace, int weight) {
		this.curPlace = curPlace;
		this.weight = weight;
	}
}

// 100
// 100
// 10
// 10 10 10 10 10 10 10 10 10 10
