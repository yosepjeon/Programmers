package Level2.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int width, height;
		String[][] clothes;

		height = scr.nextInt();
//		scr.nextLine();

		clothes = new String[height][2];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < 2; j++) {
				clothes[i][j] = scr.next();
			}
		}

		Solution solution = new Solution();

		int result = solution.solution(clothes);

		System.out.println(result);
	}
}

class Solution {
	HashMap<String, ArrayList<String>> clothMap;
	int result = 1;
	
	public int solution(String[][] clothes) {
		clothMap = new HashMap<>();
		ArrayList<String> clothList;

		for (int i = 0; i < clothes.length; i++) {
			if (clothMap.getOrDefault(clothes[i][1], null) == null) {
				ArrayList<String> addList = new ArrayList<String>();
				addList.add(clothes[i][0]);
				clothMap.put(clothes[i][1], addList);
			} else {
				ArrayList<String> getClothList = clothMap.get(clothes[i][1]);
				getClothList.add(clothes[i][0]);
			}

		}
		
		Iterator<String> itr= clothMap.keySet().iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			clothList = clothMap.get(key);
			
			result *= (clothList.size()+1);
		}

		result -= 1;
		return result;
	}
}
