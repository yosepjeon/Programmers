package skill_check_level1.다트게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Practice {
	public static void main(String[] args) {
//		Scanner scr = new Scanner(System.in);
//		String testStr = scr.next();
		
		String str = "10S2D*3T";
		System.out.println(str);
		String onlyNumberPattern = "\\D";
		String onlyBonus = "[*]|[0-9]*|[#]";
		String onlyOption = "[0-9SDT]";
		String[] sList = str.split(onlyNumberPattern);
		
		System.out.println(sList.length);
		List<String> stringList = new ArrayList<String>();
		for(String s : sList) {
			System.out.println(s + " " +(s.equals("")));
			if(!s.equals(""))
				stringList.add(s);
		}
		
		System.out.println("str index start");
		for(String s : stringList) {
			System.out.println(str.indexOf(s));
		}
		
	}
	
	public static int findNumber(String number,String str) {
		return str.indexOf(number, 0);
	}
}
