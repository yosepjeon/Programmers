package kakaotest.후보키;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int row = 0, col = 0;
		String[][] relation;

		// System.out.print("row: ");
		row = scr.nextInt();
		// System.out.print("col: ");
		col = scr.nextInt();
		scr.nextLine();

		relation = new String[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				relation[i][j] = scr.next();
			}
		}

		Solution solution = new Solution();
		int answer = solution.solution(relation);

		System.out.println(answer);
	}
}

class Solution {
	static int row,col;
	
	public int solution(String[][] relation) {
        int answer = 0;
        
        row = relation.length;
        col = relation[0].length;
        
        return answer;
    }
	
	class CandidateKey {
		
	}
}

//class Solution {
//	static HashMap<String, Integer> map;
////	static LinkedList<Integer> list;
//	static PriorityQueue<Integer> list;
//	static LinkedList<CandidateKey> keys;
////	static PriorityQueue<CandidateKey> keys;
//	static String[][] str;
//	static boolean[] check;
//	static boolean[] visited;
//	static int col, row;
//	static int result = 0;
//
//	public int solution(String[][] relation) {
//		int answer = 0;
//		col = relation[0].length;
//		row = relation.length;
//		str = relation;
//		check = new boolean[col];
//		visited = new boolean[col];
//		keys = new LinkedList<>();
////		keys = new PriorityQueue<>();
////		keys = new PriorityQueue<>(new Comparator<CandidateKey>() {
////
////			@Override
////			public int compare(CandidateKey o1, CandidateKey o2) {
////				// TODO Auto-generated method stub
////				return 0;
////			}
////		});
//
//		for (int i = 1; i <= col; i++) {
//			f:
//			for (int j = 0; j < col; j++) {
//				map = new HashMap<>();
////				list = new LinkedList<>();
//				list = new PriorityQueue<>();
//				int n = 0;
//
//				// System.out.println("중간 visit");
//				// for(boolean element:visited) {
//				// System.out.print(element + " ");
//				// }
//				// System.out.println();
//				
//				for (CandidateKey c : keys) {
//					if (list.equals(c.list)) {
//						continue;
//					}
//
//					for (int element : c.list) {
//						if (element == j) {
////							System.out.println("!");
//							continue f;
//						}
//					}
//				}
//
//				list.add(j);
//				visited[j] = true;
//				findCandidateKey(j, 1, i);
//				visited[j] = false;
//
//			}
//		}
//
//		// System.out.println("최종 check");
//		// for(boolean element:check) {
//		// System.out.print(element + " ");
//		// }
//		// System.out.println();
//
//		answer = result;
//
////		for (CandidateKey c : keys) {
////			for (int element : c.list) {
////				System.out.print(element + " ");
////			}
////			System.out.println();
////		}
//
//		return answer;
//	}
//
//	public void findCandidateKey(int start, int num, int i) {
//		String key = "";
//		int count = 0;
//
//		if (num == i) {
//
//			for (int r = 0; r < row; r++) {
//				key = "";
//				for (CandidateKey c : keys) {
//					if (list.equals(c.list)) {
//						return;
//					}
//				}
//
//				for (int index : list) {
//					key += str[r][index];
//				}
//
//				if (map.putIfAbsent(key, 1) != null) {
//					// System.out.println("중복...");
//					return;
//				}
//			}
//
//			keys.add(new CandidateKey(list));
//			result++;
//		} else {
//			for (int j = start + 1; j < col; j++) {
//				for (CandidateKey c : keys) {
//					if (list.equals(c.list)) {
//						return;
//					}
//
//					for (int element : c.list) {
//						if (element == j) {
//							return;
//						}
//					}
//				}
//				list.add(j);
//
//				visited[j] = true;
//				findCandidateKey(j, num + 1, i);
//				visited[j] = false;
//			}
//		}
//	}
//
//	class CandidateKey {
////		LinkedList<Integer> list;
//		PriorityQueue<Integer> list = new PriorityQueue<>();
//
//		public CandidateKey(PriorityQueue<Integer> list) {
//			this.list = list;
//		}
//	}
//}

// public void findCandidateKey(int start,int num,int i) {
// CandidateKey c = new CandidateKey();
//
// String key = "";
// int count = 0;
// if(num == i) {
// for(int n=0;n<row;n++) {
// count = 0;
// key = "";
//
// for(int index: list) {
// if(check[index]) {
// count++;
// if(count == i-1)
// return;
// }
//// System.out.println(index);
// key += str[n][index];
// }
//// System.out.println(key);
//
// if(map.putIfAbsent(key, 1) != null) {
//// System.out.println("중복");
// return;
// }
//// System.out.println(key);
// }
//
// for(int index: list) {
//// if(check[index])
//// return;
//// System.out.print(index + " ");
// check[index] = true;
// }
//// System.out.println();
//// System.out.println("성공...");
// result++;
// }else {
// for(int j=start+1;j<col;j++) {
// if(!visited[j]) {
// list.add(j);
// visited[j] = true;
// findCandidateKey(j,num+1,i);
// visited[j] = false;
// }
// }
// }
// }

// 6
// 4
// 100 ryan music 2
// 200 apeach math 2
// 300 tube computer 3
// 400 con computer 4
// 500 muzi music 3
// 600 apeach music 2

// 6
// 4
// 100 ryan music 1
// 200 apeach math 2
// 300 tube computer 2
// 400 con computer 4
// 500 muzi music 5
// 600 apeach music 6

// 6
// 4
// 100 ryan music 1
// 200 apeach math 2
// 300 tube computer 3
// 400 con computer 4
// 500 muzi music 5
// 600 apeach music 6

// class Solution {
// static HashMap<String, Integer> map;
// static LinkedList<Integer> list;
// static String[][] str;
// static boolean[] check;
// static boolean[] visited;
// static int col, row;
// static int result = 0;
//
// public int solution(String[][] relation) {
// int answer = 0;
// col = relation[0].length;
// row = relation.length;
// str = relation;
// check = new boolean[col];
// visited = new boolean[col];
//
// for(int i=1;i<=col;i++) {
// for(int j=0;j<col;j++) {
// map = new HashMap<>();
// list = new LinkedList<>();
// int n=0;
// for(boolean visit: check) {
// visited[n++] = visit;
// }
//
//// System.out.println("중간 visit");
//// for(boolean element:visited) {
//// System.out.print(element + " ");
//// }
//// System.out.println();
//
// if(!visited[j]) {
// list.add(j);
// visited[j] = true;
// findCandidateKey(j,1,i);
// visited[j] = false;
// }else {
//// System.out.println("안되!!!");
// }
// }
// }
//
//// System.out.println("최종 check");
//// for(boolean element:check) {
//// System.out.print(element + " ");
//// }
//// System.out.println();
//
// answer = result;
//
// return answer;
// }
//
// public void findCandidateKey(int start,int num,int i) {
// String key = "";
// if(num == i) {
// for(int n=0;n<row;n++) {
// key = "";
// for(int index: list) {
// if(check[index])
// continue;
//// System.out.println(index);
// key += str[n][index];
// }
//// System.out.println(key);
//
// if(map.putIfAbsent(key, 1) != null) {
//// System.out.println("중복");
// return;
// }
//// System.out.println(key);
// }
// for(int index: list) {
//// if(check[index])
//// return;
// check[index] = true;
// }
//// System.out.println("성공...");
// result++;
// }else {
// for(int j=start+1;j<col;j++) {
// if(!visited[j]) {
// list.add(j);
// visited[j] = true;
// findCandidateKey(j,num+1,i);
// visited[j] = false;
// }
// }
// }
// }
// }
