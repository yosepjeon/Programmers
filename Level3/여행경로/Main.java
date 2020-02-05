package Level3.여행경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String[][] tickets;
		int ticketCount = scr.nextInt();
		scr.nextLine();
		tickets = new String[ticketCount][2];

		for (int i = 0; i < ticketCount; i++) {
			for (int j = 0; j < 2; j++) {
				tickets[i][j] = scr.next();
			}
		}

		Solution solution = new Solution();

		String[] answers = solution.solution(tickets);

		StringBuffer sb = new StringBuffer();
		for (String answer : answers) {
			sb.append(answer + " ");
		}

		System.out.println(sb.toString());
	}
}

class Solution {
	static int totalTicketCount;
	static boolean flag = false;

	public String[] solution(String[][] tickets) {
		String[] answer;
		String start, end;

		Map<String, ArrayList<Ticket>> ticketMap = new HashMap<>();
		totalTicketCount = tickets.length;

		for (int i = 0; i < totalTicketCount; i++) {
			start = tickets[i][0];
			end = tickets[i][1];

			Ticket ticket = new Ticket(start, end);

			ArrayList<Ticket> ticketList;
			if (ticketMap.getOrDefault(start, null) == null) {
				ticketList = new ArrayList<>();

				ticketList.add(ticket);
				ticketMap.put(start, ticketList);
			} else {
				ticketList = ticketMap.get(start);
				ticketList.add(ticket);
			}
		}

		ticketMap.values().forEach((list) -> list.sort((t1, t2) -> t1.end.compareTo(t2.end)));

		answer = new String[totalTicketCount+1];
		doTripDFS(ticketMap, "ICN", 0, answer);
		
		return answer;
	}

	public static void doTripDFS(Map<String, ArrayList<Ticket>> ticketMap, String start, int count, String[] answer) {
//		System.out.print(start + "(" + count +  ")-> ");
		if (count == totalTicketCount) {
//			System.out.println("!");
			answer[count] = start;
			flag = true;
			return;
		}

//		sb.append(start);
		answer[count] = start;

		List<Ticket> ticketList = ticketMap.get(start);
		
		// 요놈!!!!
		if(ticketList == null)
			return;

		ticketList.forEach(element -> {
			if (!element.use) {
				element.use = true;
				doTripDFS(ticketMap, element.end,count+1,answer);
				if(flag) {
					return;
				}
				element.use = false;
			}
		});
	}

	public static void doTripBFS(Map<String, ArrayList<Ticket>> ticketMap, String start) {

	}

	class Ticket {
		String start;
		String end;
		boolean use;

		public Ticket(String start, String end) {
			this.start = start;
			this.end = end;
			this.use = false;
		}
	}
}

// 3
// ICN JFK
// HND IAD
// JFK HND

// 5
// ICN SFO
// ICN ATL
// SFO ATL
// ATL ICN
// ATL SFO

// 4
// ICN COO
// ICN BOO
// COO ICN
// BOO DOO
