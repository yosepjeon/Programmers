package skill_check_level1.p2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
//		int[] answer = solution.solution(5, stages);
		
		int[] stages = {1,2,2,4};
		int[] answer = solution.solution(5, stages);
		
		for(int a : answer) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		double[] stagesResult = new double[N+1];
		
		for(int i=0;i<N;i++) {
			stagesResult[i] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			double count = 0;
			double ing = 0;
			
			for(int j=0;j<stages.length;j++) {
				if(stages[j] >= i) {
					count += 1;
				}
				
				if(stages[j] == i) {
					ing += 1;
				}
			}
//			System.out.println("ing: " + ing + "/ count: " + count);
			stagesResult[i] = ing / count;
			
		}
		
		List<Stage> stageList = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			stageList.add(new Stage(i,stagesResult[i]));
		}
		
		stageList.sort((Stage s1,Stage s2) -> {
			if(s1.result < s2.result) {
				return 1;
			}else if(s1.result > s2.result) {
				return -1;
			}else {
				return s1.id - s2.id;
			}
		});
		
		for(int i=0;i<stageList.size();i++) {
			answer[i] = stageList.get(i).id;
		}

		return answer;
	}

	class Stage {
		int id;
		double result;

		public Stage(int id, double result) {
			this.id = id;
			this.result = result;
		}
	}
}