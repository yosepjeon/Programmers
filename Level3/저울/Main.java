package Level3.저울;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args ) {
		Solution solution = new Solution();
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		
		System.out.println(solution.solution(weight));
	}
}

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        
        int n = 1;
        Arrays.sort(weight);
        
        while(true) {
        	if(!calculate(weight, 0,n,0)) {
        		answer = n;
        		break;
        	}else { 
        		n++;
        		continue;
        	}
        }
        
        return answer;
    }
    
    private boolean calculate(int[] weight, int num,int target, int index) {
    	if(index == weight.length) {
//    		System.out.println(num);
    		return false;
    	}
    	
    	if(num == target)
    		return true;
    	
    	for(int i=index;i<weight.length; i++) {
    		if(calculate(weight, num + weight[i], target, i+1)) {
    			return true;
    		}else {
    			continue;
    		}
    	}
    	
    	return false;
    }
}
