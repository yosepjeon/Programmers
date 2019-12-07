package kakaotest.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		String[] record;
		int N;
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		scr.nextLine();
		
		record = new String[N];
		
		for(int i=0;i<N;i++) {
			record[i] = scr.nextLine();
		}

		
		Solution solution = new Solution();
		String[] answer = solution.solution(record);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
	static Map<String, String> map = new HashMap<>();
	
	public String[] solution(String[] record) {
        String[] answer;
        String[] element;
        String[] commands = null;
        StringBuffer sb = null;
        List<String> answerList = new ArrayList<>();
        int i=0;
        
        for(String elem : record) {
        	element = elem.split(" ");
        	
        	if(element[0].equals("Enter")) {
        		map.put(element[1], element[2]);
        	}else if(element[0].equals("Change")) {
        		map.replace(element[1], element[2]);
        	}
        }
        
//        answer = new String[record.length];
        for(String elem : record) {
        	element = elem.split(" ");
//        	answer[i] = "";
//        	System.out.println(element[0]);
        	
        	if(element[0].equals("Enter")) {
        		answerList.add(map.get(element[1]) + "님이 들어왔습니다.");
//        		answer[i] += map.get(element[1]) + "님이 들어왔습니다.";
        	}else if(element[0].equals("Leave")) {
        		answerList.add(map.get(element[1]) + "님이 나갔습니다.");
//        		answer[i] += map.get(element[1]) + "님이 나갔습니다.";
        	}
        	i++;
        }
        
        answer = new String[answerList.size()];
        int num=0;
        for(String s : answerList) {
        	answer[num++] = s;
        }
        System.out.println(answer.length);
        return answer;
    }
}

//5
//Enter uid1234 Muzi
//Enter uid4567 Prodo
//Leave uid1234
//Enter uid1234 Prodo
//Change uid4567 Ryan