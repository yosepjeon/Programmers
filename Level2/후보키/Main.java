package Level2.후보키;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
//        String[][] relation = {{"a","aa"},{"aa","a"},{"a","a"}};
        String[][] relation = {{"a","aa","b"},{"aa","a","c"},{"a","a","e"}};
        System.out.println(solution.solution(relation));
    }
}

class Solution {
    static int rowLen;
    static int colLen;
    static int keyCount = 0;
    static Map<String, Integer> resultMap = new HashMap<>();
    static Map<String, Integer> resultCombMap = new HashMap<>();

    public int solution(String[][] relation) {
        int answer = 0;
        List<Integer> columns = new ArrayList<>();

        rowLen = relation.length;
        colLen = relation[0].length;

        doAlgorithm(relation, columns, rowLen, 0, 0);

        answer = keyCount;
//        System.out.println(resultMap);
        System.out.println(resultCombMap);

        return answer;
    }

    public void doAlgorithm(String[][] relation, List<Integer> columns, int len, int index, int count) {
        if (count >= colLen) {
            return;
        }

        for (int i = index; i < colLen; i++) {
            columns.add(i);
            boolean result = validate(relation, columns);
            if(result) {
                columns.remove(count);
                continue;
            }
            doAlgorithm(relation, columns, len, i + 1, count + 1);
            columns.remove(count);
        }
    }

    public boolean validate(String[][] relation, List<Integer> columns) {
        System.out.println(columns);
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> combMap = new HashMap<>();
        String k = "";
        for (String[] cols : relation) {
            StringBuilder keyBuilder = new StringBuilder();
            StringBuilder combBuilder = new StringBuilder();
            int i = 0;
            for (int column : columns) {
                keyBuilder.append(cols[column]);
                combBuilder.append(columns.get(i));
                String tempKey = keyBuilder.toString();
                String tempComb = combBuilder.toString();

//                if (resultMap.getOrDefault(tempKey, null) != null) {
//                    return;
//                }

                if (resultCombMap.getOrDefault(tempComb, null) != null) {
                    return false;
                }
                i++;
            }

            String key = keyBuilder.toString();
            String comb = combBuilder.toString();

            if (map.getOrDefault(key, null) != null && resultCombMap.getOrDefault(comb, null) != null) {
                return false;
            }

            if(resultCombMap.getOrDefault(comb, null) != null) {
                return false;
            }

            Set<Integer> set = new HashSet<>();


            if (map.getOrDefault(key, null) == null && resultCombMap.getOrDefault(comb, null) == null) {
                map.put(key, 1);
                combMap.putIfAbsent(comb, 1);
            } else if (resultMap.getOrDefault(key, null) != null && resultCombMap.getOrDefault(comb, null) == null) {
                map.replace(key, map.get(key) + 1);
                combMap.putIfAbsent(comb, 1);
            } else {
                return false;
            }

        }

//        System.out.println(columns);

        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            resultMap.putIfAbsent(key, 1);
        }

        itr = combMap.keySet().iterator();
        while (itr.hasNext()) {
            String comb = itr.next();
            resultCombMap.putIfAbsent(comb, 1);
        }

        keyCount++;

        return true;
    }

    class Column {
        int id;
        String value;

        public Column(int id, String value) {
            this.id = id;
            this.value = value;
        }
    }
}

//class Solution {
//    static int rowLen;
//    static int colLen;
//    static int keyCount = 0;
//    static Map<String, Integer> resultMap = new HashMap<>();
//
//    public int solution(String[][] relation) {
//        int answer = 0;
//        List<Integer> columns = new ArrayList<>();
//
//        rowLen = relation.length;
//        colLen = relation[0].length;
//
//        doAlgorithm(relation, columns, rowLen, 0, 0);
//
//        answer = keyCount;
//
//        Iterator<String> itr = resultMap.keySet().iterator();
//        while(itr.hasNext()) {
//            String key = itr.next();
//            System.out.println(key);
//        }
//
//        return answer;
//    }
//
//    public void doAlgorithm(String[][] relation, List<Integer> columns, int len, int index, int count) {
//        if (count >= colLen) {
//            return;
//        }
//
//        for (int i = index; i < colLen; i++) {
//            columns.add(i);
//            validate(relation, columns);
//            doAlgorithm(relation, columns, len, i + 1, count + 1);
//            columns.remove(count);
//        }
//    }
//
//    public void validate(String[][] relation, List<Integer> columns) {
//        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> combMap = new HashMap<>();
//
//        String k = "";
//        for (String[] cols : relation) {
//            StringBuilder keyBuilder = new StringBuilder();
//            StringBuilder columCombBuilder = new StringBuilder();
//            int i=0;
//
//            for (int column : columns) {
//                keyBuilder.append(cols[column]);
//                columCombBuilder.append(i);
//                String tempKey = keyBuilder.toString();
//                String comb = columCombBuilder.toString();
////                if(resultMap.getOrDefault(tempKey, null) != null) {
//                if(resultMap.getOrDefault(comb, null) != null) {
////                    System.out.println("최소성 만족X");
//                    return;
//                }
//                i++;
//            }
//
//            String key = keyBuilder.toString();
//            String comb = columCombBuilder.toString();
////            if (map.getOrDefault(key, null) != null) {
////                System.out.println("유일성 만족X");
////                return;
////            } else {
////                map.put(key, 1);
////            }
//
//            if (combMap.getOrDefault(comb, null) != null) {
////                System.out.println("유일성 만족X");
//                return;
//            } else {
//                combMap.put(comb, 1);
//            }
//        }
//
//
//        Iterator<String> itr = combMap.keySet().iterator();
//        while(itr.hasNext()) {
//            String key = itr.next();
//            System.out.println(key);
//            resultMap.put(key, 1);
//        }
////        Iterator<String> itr = map.keySet().iterator();
////        while(itr.hasNext()) {
////            String key = itr.next();
////            resultMap.put(key, 1);
////        }
//
//        keyCount++;
//    }
//}
