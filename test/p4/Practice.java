package test.p4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Practice {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		String str1 = "a";
		String str2 = "c";
		
		System.out.println(str1.compareTo(str2));
	}
}
