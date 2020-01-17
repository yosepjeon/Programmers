package Level3.가장먼노드;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();
		int k = scr.nextInt();
		int[][] edge = new int[k][2];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				edge[i][j] = scr.nextInt();
			}
		}

		Solution solution = new Solution();

		System.out.println(solution.solution(n, edge));
	}
}

class Solution {
	public int solution(int n, int[][] edge) {
		int answer = 0;
		LinkedList<Node> nodes = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			nodes.add(new Node(i));
		}
		
		int edgeSize = edge.length;
		for(int i=0;i<edgeSize;i++) {
			nodes.get(edge[i][0]-1).connectedNodes.add(nodes.get(edge[i][1]-1));
			nodes.get(edge[i][1]-1).connectedNodes.add(nodes.get(edge[i][0]-1));
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(nodes.get(0));
		nodes.get(0).isVisited = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			LinkedList<Node> connectedNodes = node.connectedNodes;
			
			for(Node connectedNode : connectedNodes) {
				if(!connectedNode.isVisited) {
					connectedNode.isVisited = true;
					connectedNode.distance = node.distance+1;
					queue.add(connectedNode);
				}
			}
		}
		
		Collections.sort(nodes,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.distance - o1.distance;
			}
		});
		
		int max = nodes.get(0).distance;
		
		for(Node node : nodes) {
			if(max == node.distance)
				answer++;
			else
				break;
		}
		
		return answer;
	}
	
	class Node {
		int id;
		int distance;
		LinkedList<Node> connectedNodes;
		boolean isVisited;
		
		public Node(int id) {
			this.id = id;
			this.distance = 0;
			this.connectedNodes = new LinkedList<>();
			this.isVisited = false;
		}
	}
}

//class Solution {
//	boolean[] visited;
//	int[] distanceArray;
//	int[][] map;
//	int N;
//	int max = Integer.MIN_VALUE;
//
//	public int solution(int n, int[][] edge) {
//		int answer = 0;
//		visited = new boolean[n + 1];
//		distanceArray = new int[n + 1];
//		map = new int[n + 1][n + 1];
//		N = n;
//
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= n; j++) {
//				map[i][j] = 0;
//			}
//			distanceArray[i] = Integer.MAX_VALUE;
//		}
//		distanceArray[1] = 0;
//
//		for (int i = 0; i < edge.length; i++) {
//			map[edge[i][0]][edge[i][1]] = 1;
//			map[edge[i][1]][edge[i][0]] = 1;
//		}
//
//		visited[1] = true;
//		for (int i = 2; i <= n; i++) {
//			if (map[1][i] == 1) {
//				visited[i] = true;
//				bfs(1, i);
//				visited[i] = false;
//			}
//		}
////		System.out.println("max: " + max);
//
//		for (int i = 1; i <= n; i++) {
////			System.out.print(distanceArray[i]);
//			if (max == distanceArray[i])
//				answer++;
//		}
////		System.out.println();
//
//		return answer;
//	}
//
//	public void bfs(int distance, int vertax) {
//		if (distanceArray[vertax] > distance){
//			distanceArray[vertax] = distance;
//			max = distanceArray[vertax];
////			if (max < distance) {
////				max = distance;
////				System.out.println(distance);
//////				System.out.println("v: " + vertax);
////			}
//		}
//
//		for (int i = 1; i <= N; i++) {
//			if (map[vertax][i] == 1 && !visited[i]) {
//				visited[i] = true;
//				bfs(distance + 1, i);
//				visited[i] = false;
//			}
//
//		}
//	}
//	
//	class Node {
//		int id;
//		LinkedList<Node> connectedNodes;
//		boolean isVisited;
//		
//		public Node(int id) {
//			this.id = id;
//			this.connectedNodes = new LinkedList<>();
//			this.isVisited = false;
//		}
//	}
//}
// 6
// 7
// 3 6
// 4 3
// 3 2
// 1 3
// 1 2
// 2 4
// 5 2
