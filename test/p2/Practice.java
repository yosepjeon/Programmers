package test.p2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Practice {
	public static void main(String[] args) {
		String str1 = "PM 01:00:00";
		String[] strArr = str1.split(" ");
		
		for(String element : strArr) {
//			System.out.println(element);
		}
		
//		LocalTime time = LocalTime.parse(strArr[1]);
		
//		System.out.println(time.getHour());
		
		LocalTime.parse(str1, DateTimeFormatter.ofPattern("a hh:mm:ss"));
//		LocalTime localTime = LocalTime.parse(strArr[1]);
		LocalTime localTime = LocalTime.parse(str1, DateTimeFormatter.ofPattern("a hh:mm:ss"));
		String[] sArr = localTime.toString().split(":");
//		System.out.println(sArr.length);
//		System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

		//		String getTime = localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond();
		
		LocalTime localTime2 = LocalTime.parse(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")), DateTimeFormatter.ofPattern("HH:mm:ss"));
		String answer = localTime2.plusSeconds(10).format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString();
		System.out.println(localTime2.plusSeconds(10));
	}
}
