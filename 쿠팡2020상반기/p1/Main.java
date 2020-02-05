package 쿠팡2020상반기.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public int[] solution(int n, int min_position, int max_position, int[] positions) {
		int[] answer;

		Map<Integer, Home> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int position : positions) {
			Home home = new Home(position);
			home.setComplete(true);
			map.put(position, home);
		}

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			int key = itr.next();

			if (map.getOrDefault(key * -1, null) == null) {
				list.add(key * -1);
			}
		}

		if (map.getOrDefault(max_position, null) == null) {
			list.add(max_position);
		}

		if (map.getOrDefault(max_position * -1, null) == null) {
			list.add(max_position * -1);
		}

		if (map.getOrDefault(min_position, null) == null) {
			list.add(min_position * -1);
		}

		if (map.getOrDefault(min_position*-1, null) == null) {
			list.add(min_position * -1);
		}
		list.sort((e1, e2) -> e1 - e2);

		answer = new int[list.size()];

		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	class Home {
		int id;
		boolean isComplete;

		public Home(int id) {
			this.id = id;
			this.isComplete = false;
		}

		public boolean isComplete() {
			return isComplete;
		}

		public void setComplete(boolean isComplete) {
			this.isComplete = isComplete;
		}
	}
}
