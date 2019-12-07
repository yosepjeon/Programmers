package kakao인턴십.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args ) {
		Solution solution = new Solution();		
		
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		int[] moves  ={1,5,3,5,1,2,1,4};
		
		int result = solution.solution(board, moves);
		System.out.println(result);
	}
	
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Stack<Integer>> list = new ArrayList<>(); 
        
        List<Integer> vector = new ArrayList<Integer>();
        
        for(int x = 0;x<board.length;x++) {
        	Stack<Integer> stack = new Stack<>();
        	for(int y=board.length-1;y>=0;y--) {
//        		if(board[y][x] != 0) {
//        			stack.add(board[y][x]);
//        		}
        		System.out.print(board[y][x]);
        	}
        	System.out.println();
        	list.add(stack);
        }
        
        for(int move : moves) {
        	Stack<Integer> stack = list.get(move-1);
        	
        	if(stack.size() == 0) {
//        		System.out.println("empty");
        		continue;
        	}
        	
        	vector.add(stack.pop());
//        	System.out.println(vector);
        	
        	if(vector.size() == 1) {
        		continue;
        	}
        	
        	int vectorSize = vector.size();
        	if(vector.get(vectorSize-1) == vector.get(vectorSize-2)) {
        		vector.remove(vectorSize-1);
        		vector.remove(vectorSize-2);
        		answer += 2;
        	}
        }
        
        return answer;
    }
}
