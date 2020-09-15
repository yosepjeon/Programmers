package Level3.추석트래픽.시도2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) throws ParseException {
		Scanner scr= new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = simpleDateFormat.parse("2016-09-15 20:59:57.421");
		
		LocalDateTime localDateTime = LocalDateTime.parse("2016-09-15 20:59:57.421", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		LocalDateTime localDateTime2 = LocalDateTime.parse("2016-09-15 01:00:04.002", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(localDateTime));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(localDateTime.minusNanos(351000000)));
	
		System.out.println("----------------");
		
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(localDateTime2));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(localDateTime2.minus(1999,ChronoUnit.MILLIS)));
	
//		String time = scr.nextLine();
		String time = "2016-09-15 01:00:04.002 2.0s";
		String[] splitString = time.split(" ");
		
		int secondIndex = splitString[2].indexOf("s");
		String inputMilliSeconds = splitString[2].substring(0,secondIndex);
		double parsedMilliSeconds = Double.valueOf(inputMilliSeconds);
		System.out.println(splitString[2].substring(0,secondIndex));
		
		int processTime = (int)((parsedMilliSeconds-0.001) * 1000);
		System.out.println(parsedMilliSeconds-0.001);
		System.out.println("processTime: " + processTime);
		
		LocalDateTime endTime = LocalDateTime.parse("2016-09-15 01:00:04.002", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		LocalDateTime startTime = endTime.minus(processTime,ChronoUnit.MILLIS);
		
		System.out.println("startTime: " + startTime);
		System.out.println("endTime: " + endTime);
		System.out.println(startTime.compareTo(endTime));
		
		LocalDateTime endTime1 = LocalDateTime.parse("2016-09-15 01:00:04.002", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		LocalDateTime endTime2 = LocalDateTime.parse("2016-09-15 01:00:04.002", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		System.out.println(endTime1.compareTo(endTime2));
	}
}
