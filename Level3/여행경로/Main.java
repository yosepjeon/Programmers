package Level3.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
	public String[] solution(String[][] tickets) {
		String[] answer = null;
		List<String> answerList;
		List<Ticket> ticketList = new ArrayList<>();
		Map<String, LinkedList<Ticket>> map = new HashMap<>();

		// List<Ticket> icnList = new ArrayList<>();
		int ticketLen = tickets.length;

		for (int i = 0; i < ticketLen; i++) {
			Ticket ticket;
			if (map.getOrDefault(tickets[i][0], null) == null) {
				map.put(tickets[i][0], new LinkedList<Ticket>());
				ticket = new Ticket(tickets[i][0], tickets[i][1]);
				map.get(tickets[i][0]).add(ticket);
				ticketList.add(ticket);
			} else {
				ticket = new Ticket(tickets[i][0], tickets[i][1]);
				map.get(tickets[i][0]).add(ticket);
				ticketList.add(ticket);
			}
		}
		
		sortListInMap(map);

		while(true) {
			answerList = new ArrayList<>();
			answerList.add("ICN");
			
			Queue<Ticket> q = map.get("ICN");
			q.peek().isVisited = true;
			dfs(map, q.peek().destination, answerList);
			
			if(isCorrectPath(ticketList)) {
				break;
			}else {
				setAllVisitedAttribute(ticketList);
				Ticket t = q.poll();
				q.add(t);
			}
		}
		
		answer = new String[answerList.size()];

		int answerSize = answer.length;
		for (int i = 0; i < answerSize; i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
	
	public void dfs(Map<String, LinkedList<Ticket>> map, String key, List<String> answerList) {
		LinkedList<Ticket> q = map.get(key);
		if(q == null) {
			answerList.add(key);
			return;
		}
		
		if (q.peek().isVisited) {
			return;
		}

		Ticket next = q.poll();
		q.add(next);
//		System.out.println("call dfs");
		answerList.add(next.start);
		
		next.isVisited = true;
//		System.out.println(next.start + ":" + next.destination);
		dfs(map, next.destination, answerList);
	}
	
	public void sortListInMap(Map<String,LinkedList<Ticket>> map) {
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			
			List<Ticket> ticketList = map.get(key);
			
			ticketList.sort(new Comparator<Ticket>() {

				@Override
				public int compare(Ticket o1, Ticket o2) {
					// TODO Auto-generated method stub
					return o1.destination.compareTo(o2.destination);
				}
			});
		}
	}

	public boolean isCorrectPath(List<Ticket> ticketList) {
		for (Ticket ticket : ticketList) {
			if (!ticket.isVisited) {
//				System.out.println(ticket.start + ":" + ticket.destination);
				return false;
			}
		}

		return true;
	}
	
	public void setAllVisitedAttribute(List<Ticket> ticketList) {
		for(Ticket ticket : ticketList) {
			ticket.isVisited = false;
		}
	}

	class Ticket {
		String start, destination;
		boolean isVisited;

		public Ticket(String start, String destination) {
			this.start = start;
			this.destination = destination;
			isVisited = false;
		}
	}
}

// class Solution {
// public String[] solution(String[][] tickets) {
// String[] answer = null;
// List<String> answerList = new ArrayList<>();
//
// Map<String, PriorityQueue<String>> map = new HashMap<>();
//
// // List<Ticket> icnList = new ArrayList<>();
// int ticketLen = tickets.length;
//
// for (int i = 0; i < ticketLen; i++) {
// if (map.getOrDefault(tickets[i][0], null) == null) {
// map.put(tickets[i][0], new PriorityQueue<String>(new Comparator<String>() {
// @Override
// public int compare(String o1, String o2) {
// // TODO Auto-generated method stub
// return o1.compareTo(o2);
// }
// }));
//
// map.get(tickets[i][0]).add(tickets[i][1]);
// } else {
// map.get(tickets[i][0]).add(tickets[i][1]);
// }
// }
//
//// while (answerList.size() != ticketLen) {
//// answerList = new ArrayList<>();
// answerList.add("ICN");
// dfs(map, "ICN", answerList);
// answer = new String[answerList.size()];
// System.out.println(answerList.size() + " : " + ticketLen);
//// }
//
// int answerSize = answer.length;
// for (int i = 0; i < answerSize; i++) {
// answer[i] = answerList.get(i);
// }
//
// return answer;
// }
//
// public void dfs(Map<String, PriorityQueue<String>> map, String key,
// List<String> answerList) {
// PriorityQueue<String> pq = map.get(key);
//
// if (pq == null || pq.isEmpty()) {
// return;
// }
//
// String k = pq.poll();
// answerList.add(k);
//
// dfs(map, k, answerList);
// }
//
// class Ticket {
// String start;
// PriorityQueue<String> next;
//
// public Ticket(String start) {
//
// }
// }
// }

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
