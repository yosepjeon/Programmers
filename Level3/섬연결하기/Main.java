package Level3.섬연결하기;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();

		int[][] costs;
		int costLen = scr.nextInt();
		costs = new int[costLen][3];

		for (int i = 0; i < costLen; i++) {
			for (int j = 0; j < 3; j++) {
				costs[i][j] = scr.nextInt();
			}
		}

		Solution solution = new Solution();

		System.out.println(solution.solution(n, costs));
	}
}

class Solution {
	int edgeNum;
	int N;
	LinkedList<Node> nodes;
	LinkedList<Edge> edges;
	int result = 0;
	boolean endFlag = false;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		nodes = new LinkedList<>();
		edges = new LinkedList<>();
		int costLen = costs.length;
		N = n;
		edgeNum = costs.length;

		for (int i = 1; i <= n; i++) {
			nodes.add(new Node(i));
		}

		for (int i = 0; i < costLen; i++) {
			edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
		}

		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

//		for(Edge edge : edges ) {
//			System.out.println(edge.start + " " + edge.end + " " + edge.cost);
//		}
		// System.out.println();
		// System.out.println("size: " + nodes.size());

		nodes.get(edges.get(0).start).isVisited = true;
		nodes.get(edges.get(0).end).isVisited = true;
		choiceEdge(2, 0, edges.get(0).cost);

		answer = result;

		return answer;
	}

	public void choiceEdge(int choiceCnt, int index, int total) {
		if (choiceCnt >= N) {
//			if (checkIsConnectAll()) {
				endFlag = true;
				result = total;
//			}

			return;
		}

		for (int i = 0; i < edgeNum; i++) {			
			Edge edge = edges.get(i);
			if(nodes.get(edge.end).isVisited && nodes.get(edge.start).isVisited)
				continue;
			if(!nodes.get(edge.end).isVisited && !nodes.get(edge.start).isVisited)
				continue;
			nodes.get(edge.start).isVisited = true;
			nodes.get(edge.end).isVisited = true;
			choiceEdge(choiceCnt + 1, i, total + edge.cost);
			if(endFlag)
				return;
			nodes.get(edge.start).isVisited = false;
			nodes.get(edge.end).isVisited = false;
		}
	}

	public boolean checkIsConnectAll() {
		for (Node node : nodes) {
			if (!node.isVisited) {
				return false;
			}
		}

		return true;
	}

	class Node {
		int id;
		boolean isVisited;

		public Node(int id) {
			this.id = id;
			this.isVisited = false;
		}
	}

	class Edge {
		int start, end, cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}

// 4
// 5
// 0 1 1
// 0 2 2
// 1 2 5
// 1 3 1
// 2 3 8
