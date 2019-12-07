package kakao인턴십.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

		int[] result = solution.solution(s);

		System.out.println(result);

	}
}

class Solution {
	public int[] solution(String s) {
		String pattern = "^[0-9]*$";
		List<List<String>> strLists = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		int[] answer;

		String str = s.substring(s.indexOf("{") + 1, s.lastIndexOf("}"));
		System.out.println(str);
		Map<String, String> map = new HashMap<>();
		int n;
		while ((n = str.indexOf("{")) != -1) {
			List<String> strList = new ArrayList<>();
			String[] elements = str.substring(n + 1, str.indexOf("}")).split(",");
			System.out.print("[");
			for(String e : elements) {
				System.out.print(e + " ");
			}
			System.out.println("]");
			System.out.println();

			Collections.addAll(strList, elements);
			strLists.add(strList);
			str = str.substring(str.indexOf(","),str.lastIndexOf("}")+1);
		}

		Collections.sort(strLists, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				// TODO Auto-generated method stub
				return o1.size() - o2.size();
			}
		});

		for (List<String> strList : strLists) {
			for (String element : strList) {
				if (map.getOrDefault(element, "-1").equals("-1")) {
					result.add(Integer.valueOf(element));
				}
			}
		}

		answer = new int[result.size()];
		int i = 0;
		for (int element : result) {
			answer[i++] = element;
		}

		return answer;
	}
}