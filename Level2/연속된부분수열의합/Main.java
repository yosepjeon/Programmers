package Level2.연속된부분수열의합;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] sequence = {2, 2, 2, 2, 2};

		Solution solution = new Solution();
		int k = 6;

		int[] answer = solution.solution(sequence, k);

		System.out.println(answer[0] + ", " + answer[1]);
	}
}

class Solution {
	public int[] solution(int[] sequence, int k) {

		int seqLen = sequence.length;

		int start = 0;
		int end = 0;
		int partitionSum = sequence[0];

		List<SubSequence> subSequenceList = new ArrayList<>();
		while (true) {
			System.out.println("start: " + start + ", end: " + end);
			if(partitionSum == k && start < seqLen && end < seqLen) {
				subSequenceList.add(new SubSequence(start, end));
			}

			if(start == seqLen && end == seqLen) {
				break;
			}

			if(partitionSum <= k && end < seqLen) {
				end++;

				if(end < seqLen) {
					partitionSum += sequence[end];
				}
			}else {
				if(start < seqLen) {
					partitionSum -= sequence[start];
				}

				start++;
			}
		}

		subSequenceList.sort((s1, s2) -> {
			if(s1.length > s2.length) {
				return 1;
			}else if(s1.length == s2.length) {
				return s1.start - s2.start;
			}else {
				return -1;
			}
		});

		subSequenceList.stream()
			.forEach(subSequence -> System.out.println("start: " + subSequence.start));

		return new int[]{subSequenceList.get(0).start, subSequenceList.get(0).end};
	}
}

class SubSequence{
	int start;
	int end;
	int length;

	public SubSequence(int start, int end) {
		this.start = start;
		this.end = end;
		this.length = end - start;
	}
}
