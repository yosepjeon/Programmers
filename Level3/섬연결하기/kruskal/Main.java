package Level3.섬연결하기.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	List<Edge> edges;
	int[] nodes;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		int costsSize = costs.length;
		edges = new ArrayList<>();
		nodes = new int[n];

		for (int i = 0; i < n; i++) {
			nodes[i] = i;
		}

		for (int i = 0; i < costsSize; i++) {
			edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
		}

		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (!isConnected(nodes, edge.nodes[0], edge.nodes[1])) {
				answer += edge.cost;
				union(nodes, edge.nodes[0], edge.nodes[1]);
			}
		}

		return answer;
	}

	public int getParent(int[] nodes, int index) {
		if (nodes[index] == index)
			return index;
		return nodes[index] = getParent(nodes, nodes[index]);
	}

	public void union(int[] nodes, int start, int end) {
		start = getParent(nodes, start);
		end = getParent(nodes, end);

		if (start > end)
			nodes[start] = end;
		else
			nodes[end] = start;
	}

	public boolean isConnected(int[] nodes, int start, int end) {
		int startParent = getParent(nodes, start);
		int endParent = getParent(nodes, end);

		if (startParent == endParent)
			return true;
		else
			return false;
	}
}

class Node {
	int id;
}

class Edge {
	int[] nodes;
	int cost;

	public Edge(int node1, int node2, int cost) {
		nodes = new int[2];
		this.nodes[0] = node1;
		this.nodes[1] = node2;
		this.cost = cost;
	}
}

// 4
// 5
// 0 1 1
// 0 2 2
// 1 2 5
// 1 3 1
// 2 3 8