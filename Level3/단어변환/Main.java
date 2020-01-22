package Level3.단어변환;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
	}
}

class Solution {
	boolean[] isVisited;
	int result = Integer.MAX_VALUE;
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        char[] beginChar = begin.toCharArray();
        isVisited = new boolean[begin.length()];
        
        
        return answer;
    }
    
    public void dfs(char[] begin,String target,String[] words) {
    	if(String.valueOf(begin).equals(target)) {
    		
    	}
    	
    	for(int i=0;i<words.length;i++) {
    		if(isVisited[i]) 
    			continue;
    		
    		isVisited[i] = true;
    		int count = 0;
    		char[] wordCharArr = words[i].toCharArray();
    		
    		for(int j=0;j<wordCharArr.length;j++) {
    			
    		}
    	}
    }
}
