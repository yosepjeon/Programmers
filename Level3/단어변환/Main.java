package Level3.단어변환;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		String begin = scr.next();
		String target = scr.next();
		int size = scr.nextInt();
		String[] words = new String[size];
		scr.nextLine();
		
		for(int i=0;i<size;i++) {
			words[i] = scr.next();
		}
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(begin, target, words));
	}
}

class Solution {
	boolean[] isVisited;
	int result = Integer.MAX_VALUE;
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        isVisited = new boolean[words.length];
        boolean isValidTarget = false;
        
        for(String word : words) {
        	if(word.equals(target))
        		isValidTarget = true;
        }
        
        if(!isValidTarget) {
        	return 0;
        }
        
        dfs(begin,target,words, 0);
        answer = result;
        
        return answer;
    }
    
    public void dfs(String begin,String target,String[] words, int count) {
    	if(result <= count) {
    		return;
    	}
    	
    	char[] beginChar = begin.toCharArray();
    	
    	if(String.valueOf(begin).equals(target)) {
    		if(result > count) {
    			result = count;
    			return;
    		}
    	}
    	
    	int beginCharSize = beginChar.length;
    	int wordsSize = words.length;
    	for(int i=0;i<wordsSize;i++) {
    		if(isVisited[i]) 
    			continue;
    		
    		char[] wordCharArr = words[i].toCharArray();
    		int countMatch=0;
    		int wordCharArrLen = wordCharArr.length;
    		
    		for(int j=0;j<wordCharArrLen;j++) {
    			if(beginChar[j] == wordCharArr[j]) {
    				countMatch++;
    			}
    		}
    		
    		if(countMatch == beginCharSize-1) {
    			isVisited[i] = true;
    			dfs(words[i],target,words, count + 1);
    			isVisited[i] = false;
    		}
    	}
    }
}

//hit
//cog
//6
//hot dot dog lot log cog
