package Level3.브라이언의고민;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
//		Scanner scr = new Scanner(System.in);
//		
//		String str = scr.nextLine();
//		
//		System.out.println(str.lastIndexOf("a"));
		
		String s1 = "HaEaLaLaObWORLDb";
		String s2 = s1.replace("a", "");
		System.out.println(s2);
		
		StringBuffer sb = new StringBuffer();
		sb.append("power overwhelming ");
		
		System.out.println(sb.toString());
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.println(sb.toString());
	}
}
