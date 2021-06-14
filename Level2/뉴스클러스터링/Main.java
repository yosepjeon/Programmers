package Level2.뉴스클러스터링;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ex1
        String[] str1 = {"FRANCE", "handshake", "aa1+aa2", "E=M*C^2"};
        String[] str2 = {"french", "shake hands", "AAAA12", "e=m*c^2"};

        Solution solution = new Solution();

        for (int i = 0; i < 4; i++) {
            System.out.println(solution.solution(str1[i], str2[i]));
        }

    }
}

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        setMap(str1Map, str1);
        setMap(str2Map, str2);

        double intersaction = getIntersection(str1Map, str2Map);
        double union = getUnion(str1Map, str2Map);
        double value = 1;
        if((int)union == 0 && (int)intersaction == 0) {
            value = 1;
        }else {
            value = intersaction / union;
        }

        answer = (int)(value * 65536);

        return answer;
    }

    public void setMap(Map<String, Integer> map, String str) {
        int str1Len = str.length();
        String[] condition = {"~","!","@","#","$"};


        for (int i = 0; i < str1Len - 1; i++) {
            String element = str.substring(i, i + 2);

            if(!element.matches("[A-Z]*")) {
                continue;
            }

            if (map.containsKey(element)) {
                int count = map.get(element);
                map.replace(element, count + 1);
            } else {
                map.put(element, 1);
            }
        }
    }

    public int getIntersection(Map<String, Integer> str1Map, Map<String, Integer> str2Map) {
        Set<Integer> intersactionSet = new HashSet<>();
        Iterator<String> iterator = str1Map.keySet().iterator();

        int intersaction = 0;
        while(iterator.hasNext()) {
            String key= iterator.next();

            if(str2Map.containsKey(key)) {
                if(str1Map.get(key) > str2Map.get(key)) {
                    intersaction += str2Map.get(key);
                }else {
                    intersaction += str1Map.get(key);
                }
            }
        }

        return intersaction;
    }

    public int getUnion(Map<String, Integer> str1Map, Map<String, Integer> str2Map) {
        Set<String> unionSet = new HashSet<>();
        int union = 0;

        Iterator<String> str1Iterator = str1Map.keySet().iterator();
        while(str1Iterator.hasNext()) {
            String key= str1Iterator.next();

            if(str2Map.containsKey(key)) {
                if(str1Map.get(key) < str2Map.get(key)) {
                    union += str2Map.get(key);
                }else {
                    union += str1Map.get(key);
                }
            }
        }

        str1Iterator = str1Map.keySet().iterator();
        while(str1Iterator.hasNext()) {
            String key = str1Iterator.next();

            if(!str2Map.containsKey(key)) {
                union += str1Map.get(key);
            }
        }

        Iterator<String> str2Iterator = str2Map.keySet().iterator();
        while(str2Iterator.hasNext()) {
            String key = str2Iterator.next();

            if(!str1Map.containsKey(key)) {
                union += str2Map.get(key);
            }
        }

        return union;
    }
}
