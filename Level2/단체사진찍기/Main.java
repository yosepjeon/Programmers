package Level2.단체사진찍기;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
//        String[] datas = {"N~F=0", "R~T>2"};
        String[] datas = {"M~C<2", "C~M>1"};

        System.out.print(solution.solution(n, datas));
    }
}

class Solution {
    static boolean[] isVisited = new boolean[8];
    static String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int result = 0;

    public int solution(int n, String[] data) {
        int answer = 0;
        result = 0;

        for (int i = 0; i < 8; i++) {
            Map<String, Integer> map = new HashMap<>();
            isVisited[i] = true;
            int index = 0;
            map.put(characters[i], index);
            createLine(data, map, index + 1);
            map.remove(characters[i]);
            isVisited[i] = false;
        }
        answer = result;

        return answer;
    }

    public void createLine(String[] data, Map<String, Integer> map, int index) {
        if (index == 8) {
            if(check(data,map)) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isVisited[i])
                continue;
            else {
                isVisited[i] = true;
                map.put(characters[i], index);
                createLine(data, map, index + 1);
                map.remove(characters[i]);
                isVisited[i] = false;
            }
        }
    }

    public boolean check(String[] data, Map<String, Integer> map) {
        for (String element : data) {
            String[] splitedElements = element.split("");
            int pow = Math.abs(map.get(splitedElements[0]) - map.get(splitedElements[2]));

            if (splitedElements[3].equals("=")) {
                if(pow != Integer.valueOf(splitedElements[4]) + 1) {
                    return false;
                }
            } else if (splitedElements[3].equals("<")) {
                if(pow >= Integer.valueOf(splitedElements[4]) + 1) {
                    return false;
                }
            } else if (splitedElements[3].equals(">")) {
                if(pow <= Integer.valueOf(splitedElements[4]) + 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
