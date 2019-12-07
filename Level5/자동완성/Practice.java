package Level5.자동완성;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice {
	public static void main(String[] args ) {
		String str1 = "abc";
		String str2 = "abcd";
		String str3 = "ghi";
		String str4 = "jklm";
		
		List<String> list = new ArrayList<String>();
		
		list.add(str1);
		list.add(str2);
		list.add(str3);
		list.add(str4);
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}
