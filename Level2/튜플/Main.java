package Level2.튜플;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//        String s = "{{20,111},{111}}";
//        String s = "{{123}}";
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution solution = new Solution();

        int[] result = solution.solution(s);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int element : result) {
            sb.append(element);
            sb.append(", ");
        }
        int last = sb.lastIndexOf(", ");
        sb.delete(last, last + ", ".length());
        sb.append("]");

        System.out.println(sb.toString());
    }
}

class Solution {
    public int[] solution(String s) {
        int[] answer = {2, 1, 3, 4};
        int sLen = s.length();

        List<Element> numSet = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int listSize = 0;

        for (int i = 1; i < sLen - 1; i++) {
            if (s.charAt(i) == '{') {
                list = new ArrayList<>();
                listSize = 0;
                sb = new StringBuilder();
            } else if (s.charAt(i) == ',') {
                if (s.charAt(i - 1) == '}')
                    continue;
                list.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                listSize++;
            } else if (s.charAt(i) == '}') {
                list.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                listSize++;
                numSet.add(new Element(list, listSize));
            } else {
                sb.append(s.charAt(i));
            }
        }

        numSet.sort((Element e1, Element e2) -> e1.listSize - e2.listSize);
        Map<Integer, Integer> checkMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (Element element : numSet) {
            element.list.forEach(e -> {
                if (checkMap.getOrDefault(e, -1) == -1) {
                    checkMap.put(e, 1);
                    result.add(e);
                }
            });
        }

        int resultSize = result.size();
        answer = new int[resultSize];

        for (int i = 0; i < resultSize; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class Element {
        List<Integer> list = new ArrayList<>();
        int listSize = 0;

        public Element(List<Integer> list, int listSize) {
            this.list = list;
            this.listSize = listSize;
        }
    }
}