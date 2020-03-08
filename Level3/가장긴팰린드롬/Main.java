package Level3.가장긴팰린드롬;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.solution("aaaaabaaaaaa"));
	}
}

class Solution {
	int max = 0;

	public int solution(String s) {
		int answer = 0;

		String[] strings = s.split("");
		List<Element> elements = new ArrayList<>();

		for (String string : strings) {
			elements.add(new Element(string));
		}

		int elementsSize = elements.size();

		if (elementsSize == 1)
			return 1;

		for (int i = 0; i < elementsSize - 1; i++) {
			// if
			// (elements.get(i).value.equals(elements.get(elementsSize-1).value))
			// {
			// dfs(elements, i, elementsSize-1, 1, true);
			// } else {
			// dfs(elements, i, elementsSize - 2, 0, false);
			// }
			for (int j = elementsSize - 1; j >= elementsSize/2; j--) {
				dfs(elements, i, j, 0, false);
			}
		}
		answer = max;

		return answer;
	}

	public void dfs(List<Element> elements, int start, int end, int count, boolean isEqual) {
//		 System.out.println(end);
		if (start > end && isEqual) {
			if (max < count * 2) {
				max = count * 2;
			}
			return;
		}

		if (start == end && isEqual) {
			if (max < count * 2 + 1) {
				max = count * 2 + 1;
			}
			return;
		}

		// if (!isEqual && elements.get(end).check) {
		// return;
		// }

		if (elements.get(start).value.equals(elements.get(end).value)) {
			elements.get(start).check = true;
			elements.get(end).check = true;
			dfs(elements, start + 1, end - 1, count + 1, true);
		} else {
			if (isEqual) {
				dfs(elements, start, end - 1, 0, false);
			} else {
				if (!isEqual && elements.get(end).check) {
					return;
				}
				dfs(elements, start, end - 1, count, false);
			}
		}
	}

	class Element {
		String value;
		boolean check;

		public Element(String value) {
			this.value = value;
			this.check = false;
		}
	}
}
