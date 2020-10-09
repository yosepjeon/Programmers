package Level3.단속카메라;

import java.util.ArrayList;
import java.util.List;
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

		List<Route> routeList = new ArrayList<>();

		int routeListSize = routes.length;

		for (int i = 0; i < routeListSize; i++) {
			routeList.add(new Route(routes[i][0], routes[i][1]));
		}

		routeList.sort((Route route1, Route route2) -> {
			return route1.end - route2.end;
		});

		int camera = -30001;

		for (Route element : routeList) {
			if (camera < element.start) {
				camera = element.end;
				answer++;
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
