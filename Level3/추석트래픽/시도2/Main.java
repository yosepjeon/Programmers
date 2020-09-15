package Level3.추석트래픽.시도2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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
	public int solution(String[] lines) {
		int max = 1;
		int count = 0;
		int answer = 0;
		List<Request> requests = new ArrayList<>();

		int id = 1;
		for (String line : lines) {
			String[] splitTime = line.split(" ");

			Request request = new Request(id, splitTime);
			requests.add(request);
			id++;
		}

		int requestsSize = requests.size();
		for (int i = 0; i < requestsSize; i++) {
			Request r1 = requests.get(i);
			int startCount = 1;
			int endCount = 1;
			int startPlusOneCount = 1;
			int endPlusOneCount = 1;
			boolean[] check1 = new boolean[requestsSize+1];
			boolean[] check2 = new boolean[requestsSize+1];
			check1[r1.id] = true;
			check2[r1.id] = true;

			for (int j = 0; j < requestsSize; j++) {
				Request r2 = requests.get(j);
				if (i == j) {
//					System.out.println("continue");
					continue;
				}
				

//				System.out.println();
//				System.out.println("r1.startTime= " + r1.startTime + " VS " + "r2.startTime= " + r2.startTime);
//				System.out.println("r1.startPlusOneTime= " + r1.startTimePlusOneSecond + " VS " + "r2.startTime= " + r2.startTime);
//				System.out.println("r1.endTime= " + r1.endTime + " VS " + "r2.endTime= " + r2.endTime);
//				System.out.println("r1.endPlusOneTime= " + r1.endTimePlusOneSecond + " VS " + "r2.endTime= " + r2.endTime);
//				System.out.println();
				
//				if ((r1.startTime.compareTo(r2.startTime) >= 0 && r1.startTime.compareTo(r2.endTime) <= 0)) {
//					startCount++;
//					check1[r2.id] = true;
//				}


//				if ((r1.startTimePlusOneSecond.compareTo(r2.startTime) >= 0
//						&& r1.startTimePlusOneSecond.compareTo(r2.endTime) <= 0)) {
//					startPlusOneCount++;
//					check1[r2.id] = true;
//				}
				
				if ((r1.endTime.compareTo(r2.startTime) >= 0 && r1.endTime.compareTo(r2.endTime) <= 0)) {
					endCount++;
					check2[r2.id] = true;
				}

				if ((r1.endTimePlusOneSecond.compareTo(r2.startTime) >= 0
						&& r1.endTimePlusOneSecond.compareTo(r2.endTime) <= 0)) {
					endPlusOneCount++;
					check2[r2.id] = true;
				}
				
				if((r1.endTime.compareTo(r2.startTime) > 0) &&
						(r1.endTime.compareTo(r2.endTime) < 0)) {
					endPlusOneCount++;
					check2[r2.id] = true;
				}
				
				
//				System.out.println("compare: " + r1.endTimePlusOneSecond.compareTo(r2.startTime));
			}
//			System.out.println(startCount + ", " + startPlusOneCount + ", " + endCount + ", " + endPlusOneCount);
			
			int check1Count = 0;
			int check2Count = 0;
			
//			for(int j=1;j<requestsSize;j++) {
//				System.out.print(check1[j] + " ");
//			}
//			System.out.println();
//			
//			for(int j=1;j<requestsSize;j++) {
//				System.out.print(check2[j] + " ");
//			}
//			System.out.println();
			
			for(int j=1;j<=requestsSize;j++) {
				if(check1[j])
					check1Count++;
				
				if(check2[j])
					check2Count++;
			}
//			System.out.println(check1Count + ", " + check2Count);
			
//			max = Integer.max(max,Integer.max(Integer.max(startCount, endCount), Integer.max(startPlusOneCount, endPlusOneCount)));
			max = Integer.max(max, Integer.max(check1Count, check2Count));
		}

		answer = max;
		return answer;
	}

	class Request {
		int id;
		LocalDateTime startTime;
		LocalDateTime endTime;
		LocalDateTime startTimePlusOneSecond;
		LocalDateTime endTimePlusOneSecond;

		public Request(int id, String[] splitTime) {
			this.id = id;
			int secondIndex = splitTime[2].indexOf("s");
			String inputMilliSeconds = splitTime[2].substring(0, secondIndex);
			double parsedMilliSeconds = Double.valueOf(inputMilliSeconds);

			int processTime = (int) ((parsedMilliSeconds - 0.001) * 1000);

			this.endTime = LocalDateTime.parse(splitTime[0] + " " + splitTime[1],
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			this.startTime = endTime.minus(processTime, ChronoUnit.MILLIS);
			this.startTimePlusOneSecond = startTime.plus(999, ChronoUnit.MILLIS);
			this.endTimePlusOneSecond = endTime.plus(999, ChronoUnit.MILLIS);
		}
	}
}

// case1
//2
//2016-09-15 01:00:04.001 2.0s
//2016-09-15 01:00:07.000 2s

// case2
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
