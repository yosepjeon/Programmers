package kakao인턴십.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice {
	public static void main(String[] args ) {
//		String str = "{1,2,3},{2,1},{1,2,4,3},{2}";
//		System.out.println(str.lastIndexOf("}"));
//		String s = str.substring(str.indexOf("{")+1,str.lastIndexOf("}"));
//		String[] elements = str.substring(str.indexOf("{")+1,str.indexOf("}")).split(",");
//    	
//		
//		System.out.println(elements[0]+"," +elements[1]+","+elements[2]);
		
//		List<Integer> list=  new ArrayList<Integer>();
//		list.add(5);
//		list.add(4);
//		list.add(3);
//		list.add(2);
//		list.add(1);
//		
//		Collections.sort(list,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o1-o2;
//			}
//		});
//		
//		for(int i : list) {
//			System.out.println(i);
//		}
		
		String star = "[a-z0-9]";
		String pattern = "[a-z][a-z]";
		String str1 = "fr.do";
		String str2 = ".....";
		if(str1.matches(pattern)) {
			System.out.println("@");
		}else {
			System.out.println("!");
		}
//		if(str.matches(pattern)) {
//			System.out.println(str);
//		}
	}
}
