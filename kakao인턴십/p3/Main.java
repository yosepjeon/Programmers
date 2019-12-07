package kakao인턴십.p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args ) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		
		Solution solution = new Solution();
		
		System.out.println(solution.solution(user_id, banned_id));
	}
}

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();
        
        String star = "[a-z0-9]";
        String star2 = ".";
//        List<String> bannedIds = new ArrayList<>();
        HashSet<String> bannedIds = new HashSet<>();
        HashSet<String> bannedIdsByDot = new HashSet<>();
        for(String bid : banned_id) {
        	String bannedId = "";
        	String bannedIdByDot = "";
        	char[] carr = bid.toCharArray();
        	
        	for(char c : carr) {
        		if(c == '*') {
        			bannedId += star;
        			bannedIdByDot +=star2;
        		}else {
        			bannedId += c;
        		}
        	}

        	bannedIds.add(bannedId);
        	bannedIdsByDot.add(bannedIdByDot);
        }
        
        int total = 1;
        int count = 1;
        for(String bid : bannedIds) {
        	count = 1;
        	uid:
        	for(String uid : user_id) {
        		if(!map.getOrDefault(uid, "").equals("")){
        			continue;
        		}
        		if(uid.matches(bid)) {
        			Iterator<String> itr = map.keySet().iterator();
        			
        			while(itr.hasNext()) {
        				String key = itr.next();
        				if(key.equals(uid)) {
//        					System.out.println("!!");
        					continue uid;
        				}
        			}
        			
        			map.put(uid, uid);
        			count++;
        		}
        	}
//        	System.out.print(bid + ": ");
//        	System.out.println(count);
        	total *= count-1;
//        	System.out.println(total);
        }
        
        answer = total;
        return answer;
    }
}