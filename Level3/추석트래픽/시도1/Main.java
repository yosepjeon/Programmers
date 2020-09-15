package Level3.추석트래픽.시도1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		scr.nextLine();

		String[] lines = new String[size];

		for (int i = 0; i < size; i++) {
			lines[i] = scr.nextLine();
		}

		Solution solution = new Solution();

		System.out.println(solution.solution(lines));
	}
}

class Solution {
	public int solution(String[] lines) throws ParseException {
		int answer = 0;
		Calendar sectionEnd = Calendar.getInstance();
		Calendar sectionStart = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat keyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Section> sectionList = new ArrayList<>();
		List<Request> requestList = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		
		for (String line : lines) {
			sectionEnd = Calendar.getInstance();
			sectionStart = Calendar.getInstance();
			Calendar sectionStartBoudary = Calendar.getInstance();
			Calendar sectionEndBoundary = Calendar.getInstance();
			
//			System.out.println(line);
			String date = line.substring(0, line.lastIndexOf(" "));
			int processSeconds;
			int processMilliSeconds;

			if (line.lastIndexOf(".") > line.lastIndexOf(" ")) {
				processSeconds = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1, line.lastIndexOf(".")));
				processMilliSeconds = Integer.valueOf(line.substring(line.lastIndexOf(".") + 1, line.lastIndexOf("s")));
				processMilliSeconds--;
//				System.out.println(processMilliSeconds);
			}else {
				processSeconds = Integer.valueOf(line.substring(line.lastIndexOf(" ")+1, line.lastIndexOf("s")))-1;
				processMilliSeconds = 999;
			}

			sectionEnd.setTime(simpleDateFormat.parse(date));
			sectionEndBoundary.setTime(simpleDateFormat.parse(date));
			sectionEndBoundary.add(Calendar.MILLISECOND, 999);
			
			sectionStart.setTime(simpleDateFormat.parse(date));
			sectionStart.add(Calendar.SECOND, processSeconds*-1);
			sectionStart.add(Calendar.MILLISECOND, processMilliSeconds*-1);
			sectionStartBoudary.setTime(simpleDateFormat.parse(date));
			sectionStartBoudary.add(Calendar.SECOND, processSeconds*-1);
			sectionStartBoudary.add(Calendar.MILLISECOND, processMilliSeconds*-1);
			sectionStartBoudary.add(Calendar.MILLISECOND, 999);
			
			sectionList.add(new Section(sectionStart,sectionStartBoudary));
			sectionList.add(new Section(sectionEnd, sectionEndBoundary));
			requestList.add(new Request(sectionStart,sectionEnd));
			System.out.println("리퀘스트 시작: " + simpleDateFormat.format(sectionStart.getTime()) + " 끝: " + simpleDateFormat.format(sectionEnd.getTime()));
		}
		
		int sectionListSize = sectionList.size();
		int requestListSize = requestList.size();
		
		for(int i=0;i<sectionListSize;i++) {
			int count = 1;
			Section section1 = sectionList.get(i);
			System.out.print("시작시간: " + simpleDateFormat.format(section1.getSectionStart().getTime()) + ", 끝시간: " + simpleDateFormat.format(section1.getSectionEnd().getTime()));
			
			for(int j=0;j<requestListSize;j++) {
				if(i == j)
					continue;
//				Section section2 = sectionList.get(j);
				Request request = requestList.get(j);
				if(section1.getSectionEnd().compareTo(request.getStartTime()) < 0) 
					break;
				if(section1.getSectionStart().compareTo(request.getResponseTime()) > 0)
					break;
				
				
				if(section1.getSectionStart().compareTo(request.getStartTime()) == 0) {
					System.out.print("#1");
					count++;
					continue;
				}else if(section1.getSectionStart().compareTo(request.getResponseTime()) == 0) {
					System.out.print("#2");
					count++;
					continue;
				}else if(section1.getSectionEnd().compareTo(request.getStartTime()) == 0) {
					System.out.print("#3");
					count++;
					continue;
				}else if(section1.getSectionEnd().compareTo(request.getResponseTime()) == 0) {
					System.out.print("#4");
					count++;
					continue;
				}else if(section1.getSectionStart().compareTo(request.getStartTime()) < 0 && section1.getSectionEnd().compareTo(request.getStartTime()) >= 0) {
					System.out.print("#5");
					count++;
					continue;
				}else if(section1.getSectionStart().compareTo(request.getResponseTime()) > 0 && section1.getSectionStart().compareTo(request.getResponseTime()) <= 0) {
					System.out.print("#6");
					count++;
					continue;
				}else if(request.getStartTime().compareTo(section1.getSectionStart()) < 0 && request.getResponseTime().compareTo(section1.getSectionEnd()) > 0) {
					System.out.print("#7");
					count++;
					continue;
				}
//				System.out.println();
			}
			System.out.print(" count: " + count);
			System.out.println();
			
			if(max < count) 
				max = count;
		}
		
//		sectionList.sort(new Comparator<Section>() {
//
//			@Override
//			public int compare(Section o1, Section o2) {
//				// TODO Auto-generated method stub
//				return o1.getSectionStart().compareTo(o2.getSectionStart());
//			}
//
//		});
		answer = max;
		return answer;
	}
}

class Section {
	private Calendar sectionStart;
	private Calendar sectionEnd;
	
	public Section(Calendar sectionStart, Calendar sectionEnd) {
		this.sectionStart = sectionStart;
		this.sectionEnd = sectionEnd;
	}
	
	public Calendar getSectionStart() {
		return sectionStart;
	}
	public void setSectionStart(Calendar sectionStart) {
		this.sectionStart = sectionStart;
	}
	public Calendar getSectionEnd() {
		return sectionEnd;
	}
	public void setSectionEnd(Calendar sectionEnd) {
		this.sectionEnd = sectionEnd;
	}
}

class Request {
	private Calendar startTime;
	private Calendar responseTime;
	
	public Request(Calendar startTime, Calendar responseTime) {
		this.startTime = startTime;
		this.responseTime = responseTime;
	}
	
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Calendar responseTime) {
		this.responseTime = responseTime;
	}
}

//2
//2016-09-15 01:00:04.002 2.0s
//2016-09-15 01:00:07.000 2s

//10
//2016-09-15 20:59:57.421 0.351s
//2016-09-15 20:59:58.233 1.181s
//2016-09-15 20:59:58.299 0.8s
//2016-09-15 20:59:58.688 1.041s
//2016-09-15 20:59:59.591 1.412s
//2016-09-15 21:00:00.464 1.466s
//2016-09-15 21:00:00.741 1.581s
//2016-09-15 21:00:00.748 2.31s
//2016-09-15 21:00:00.966 0.381s
//2016-09-15 21:00:02.066 2.62s