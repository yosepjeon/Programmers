package Level1.체육복;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int n = 5;
		int[] lost = {3,5};
		int[] reserve = {2,4};
		
		System.out.println(solution.solution(n, lost, reserve));
	}
}

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

//		Map<Integer, LostStudent> lostStudentMap = new HashMap<>();
		List<Integer> lostList = new LinkedList<>();
		List<Integer> reserveList = new LinkedList<>();

		for (int element : lost) {
			lostList.add(element);
		}

		for (int element : reserve) {
			reserveList.add(element);
		}

		Iterator<Integer> lostItr = lostList.iterator();
		Iterator<Integer> reserveItr = reserveList.iterator();
		while (lostItr.hasNext()) {
			int lostId = lostItr.next();
			reserveItr = reserveList.iterator();
			while (reserveItr.hasNext()) {
				int reserveId = reserveItr.next();
//				System.out.println("lostId: " + lostId + ", reserverId: " + reserveId);
				if (lostId == reserveId) {
//					System.out.println("lostId: " + lostId);
					lostItr.remove();
					reserveItr.remove();
					break;
				}
			}
		}
		
//		System.out.println(lostList);
//		System.out.println(reserveList);
		
		int lostSize = lostList.size();
		for (int i = 0; i < lostSize; i++) {
			PriorityQueue<LostStudent> pq = new PriorityQueue<>((s1, s2) -> {
				if(s1.reserveCount > s2.reserveCount) {
					return 1;
				}else if(s1.reserveCount < s1.reserveCount) {
					return -1;
				}else {
//					return 0;
					return s1.id - s2.id;
				}
//				return 1;
//				return s1.reserveCount - s2.reserveCount;
			});

			lostItr = lostList.iterator();
			while (lostItr.hasNext()) {
				int lostId = lostItr.next();

				pq.add(new LostStudent(lostId, reserveList));
			}
			
//			pq.forEach(s -> {
//				System.out.println("s.id: " + s.id + ", s.reserveCount: " + s.reserveCount);
//			});

			while (!pq.isEmpty()) {
				LostStudent s = pq.poll();
				System.out.println("s.id: " + s.id + ", s.reserveCount: " + s.reserveCount);

				reserveItr = reserveList.iterator();
				while (reserveItr.hasNext()) {
					int reserveId = reserveItr.next();
//					System.out.println("s.id: " + s.id);
					if (s.id + 1 == reserveId || s.id - 1 == reserveId) {
						lostItr = lostList.iterator();
						while (lostItr.hasNext()) {
//							System.out.println("reserveId: " + reserveId);
							int id = lostItr.next();

							if (id == s.id) {
//								System.out.println(id + " 삭제");
								lostItr.remove();
								break;
							}

						}
						reserveItr.remove();

						break;
					}
				}

			}
		}
		answer = n - lostList.size();

		return answer;
	}

	class LostStudent {
		int id;
		int reserveCount = 0;

		public LostStudent(int id, List<Integer> reserve) {
			this.id = id;
			this.reserveCount = 0;
			for (int element : reserve) {
				if (id + 1 == element || id -1 == element) {
					reserveCount++;
					continue;
				}

//				if (id - 1 == element) {
//					reserveCount++;
//					continue;
//				}
			}
		}
		
		public void setReserveCount(List<Integer> reserve) {
			for(int element : reserve) {
				if (id + 1 == element || id -1 == element) {
					reserveCount++;
					continue;
				}
			}
		}
	}
}
