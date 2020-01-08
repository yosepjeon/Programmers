package Level2.행렬의곱셈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		int w,h;
		h = scr.nextInt();
		w = scr.nextInt();
		int[][] arr1 = new int[h][w];
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				arr1[i][j] = scr.nextInt();
			}
		}
		
		h = scr.nextInt();
		w = scr.nextInt();
		int[][] arr2 = new int[h][w];
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				arr2[i][j] = scr.nextInt();
			}
		}
		
		Solution solution = new Solution();
		
		int[][] result = solution.solution(arr1, arr2);
		
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.print(result[i][j] +" ");
			}
			System.out.println();
		}
	}
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer;
        int width, height;
        
        height = arr1.length;
        width = arr2[0].length;
        
        answer = new int[height][width];
        
        for(int i=0;i<height;i++) {
        	for(int j=0;j<width;j++) {
        		int sum = 0;
        		for(int k=0;k<width;k++) {
        			sum += arr1[i][k] * arr2[k][j];
        		}
        		
        		answer[i][j] = sum;
        	}
        }
        
        return answer;
    }
}
