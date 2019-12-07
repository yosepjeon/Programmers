package Level2.스킬트리;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		Solution solution = new Solution();

		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		
		System.out.println(solution.solution("CBD", skill_trees));
	}
}

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			if(countAnswer(skill, skill_trees[i])){
				answer += 1;
			}else {
				
			}
		}

		return answer;
	}

	public boolean countAnswer(String skill, String skill_tree) {
		Queue<Character> queue = new LinkedList<>();
		int count = 0;
		char[] skillArr = new char[skill.length()];
		char[] skillTreeArr = new char[skill_tree.length()];

		skillArr = skill.toCharArray();
		skillTreeArr = skill_tree.toCharArray();

		for (int i = 0; i < skillArr.length; i++) {
			queue.add(skillArr[i]);
		}

		for (int i = 0; i < skillTreeArr.length; i++) {
			if(queue.isEmpty())
				return true;
			
			char c = skillTreeArr[i];
			char peek = (char) queue.peek();
			
			if (checkIsInSkillTree(queue, c)) {
				if(c == peek){
					queue.poll();
					continue;
				}else {
					return false;
				}
			} else {
				continue;
			}
		}

		return true;

	}

	public boolean checkIsInSkillTree(Queue queue, char elem) {
		Iterator<Character> itr = queue.iterator();

		while (itr.hasNext()) {
			char c = itr.next();

			if (c == elem)
				return true;
		}

		return false;
	}
}
