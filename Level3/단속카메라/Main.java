package Level3.단속카메라;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(routes));
	}
}

class Solution {
	public int solution(int[][] routes) {
		int answer = 0;

		// PriorityQueue<Route> pq = new PriorityQueue<>((Route route1, Route route2) ->
		// {
		// return (route2.end - route2.start) - (route1.end - route1.start);
		// });

		List<Route> routeList = new ArrayList<>();

		int routeListSize = routes.length;

		for (int i = 0; i < routeListSize; i++) {
			routeList.add(new Route(routes[i][0], routes[i][1]));
		}

		routeList.sort((Route route1, Route route2) -> {
			return (route2.end - route2.start) - (route1.end - route1.start);
		});

		System.out.println(routeList.size());
		int count = 0;
		while (!routeList.isEmpty()) {
			Route element1 = routeList.get(0);
			System.out.println("start: " + element1.start + ", end: " + element1.end);
			answer+=2;

			Iterator<Route> itr = routeList.iterator();

			while (itr.hasNext()) {
				Route element2 = itr.next();

				if (element1.start <= element2.start && element1.end >= element2.end) {
					itr.remove();
					continue;
				}
				if(element1.start > element2.start || element1.end < element2.end) {
					
				}
			}
		}

		return answer;
	}

	class Route {
		int start;
		int end;

		public Route(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
