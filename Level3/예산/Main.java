package Level3.예산;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n = scr.nextInt();
		int[] budgets = new int[n];
		
		for(int i=0;i<n;i++) {
			budgets[i] = scr.nextInt();
		}
		
		int M = scr.nextInt();
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(budgets, M));
	}
}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        int min = 0;
        int max = 0;
        
        LinkedList<Integer> list = new LinkedList<>();
//        int totalForFirstCheck = 0;
        
        for(int budget : budgets) {
        	if(budget > max)
        		max = budget;
        	
//        	list.add(budget);
//        	totalForFirstCheck += budget;
        }
        
//        Collections.sort(list, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o1 - o2;
//			}
//		});
        
//        if(totalForFirstCheck <= M) {
//        	return list.get(list.size());
//        }
        
        min = 0;
//        max = list.getLast();
        int mid=0;
        int listSize = budgets.length;
        while(min <= max) {
//        	System.out.println("min: " + min + " max: " + max);
        	int total = 0;
        	mid = (min+max)/2;
        	
        	for(int i=0;i<listSize;i++) {
//        		int element = list.get(i);
        		int element = budgets[i];
        		
        		if(element >= mid) {
        			total += mid;
        		}else {
        			total += element;
        		}
        	}
        	
        	if(total > M) {
        		max = mid - 1;
        	}else{
        		answer = mid;
        		min = mid + 1;
        	}
        	
//        	System.out.println("min: " + min + " max: " + max);
        }
//        answer = max;
        
        return answer;
    }
}

//2
//120 120
//230

//4
//120 110 140 150
//485
