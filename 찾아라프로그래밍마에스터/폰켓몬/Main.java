package 찾아라프로그래밍마에스터.폰켓몬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[] nums;
	static int size;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		size = scr.nextInt();
		nums = new int[size];
		
		for(int i=0;i<size;i++) {
			nums[i] = scr.nextInt();
		}
		
		Solution solution = new Solution();
		int result = solution.solution(nums);
		System.out.println(result);
	}
}

class Solution {
	static Map<Integer, Integer> map = new HashMap<>();
	
	public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length/2;
        
        for(int n : nums) {
        	map.putIfAbsent(n, n);
        }
        
        if(map.size() > num) {
        	answer = num;
        }else {
        	answer = map.size();
        }
        
        return answer;
    }
}
