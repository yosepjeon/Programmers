package Level2.메뉴리뉴얼;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] orders = {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        int[] course = {2, 3, 4};
//        String[] orders = {
//                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
//        };
//        int[] course = {2,3,5};
//        String[] orders = {
//                "XYZ", "XWY", "WXA"
//        };
//        int[] course = {2,3,4};


        Solution solution = new Solution();

        String[] results = solution.solution(orders, course);

        for (String result : results) {
            System.out.println(result);
        }
    }
}

class Solution {
    public static int orderLen;
    public static Map<Integer, Map<String, Element>> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        int ordersLen = orders.length;

        for (String order : orders) {
            char[] carr = order.toCharArray();

            Arrays.sort(carr);

            orderLen = order.length();

            for (int i = 0; i < orderLen; i++) {
                makeCombination(carr, new StringBuilder().append(carr[i]), orderLen, 1, i + 1);
            }
        }

        List<String> results = new ArrayList<>();

        for (int c : course) {
            if (map.getOrDefault(c, null) == null)
                continue;
            Iterator<String> itr = map.get(c).keySet().iterator();
            List<Element> elements = new ArrayList<>();

            while (itr.hasNext()) {
                String key = itr.next();

                if (map.get(c).get(key).count >= 2) {
                    elements.add(map.get(c).get(key));
                }
            }

            if (elements.isEmpty()) {
                continue;
            }

            elements.sort((Element e1, Element e2) -> {
                if (e1.count < e2.count) {
                    return 1;
                } else if (e1.count > e2.count) {
                    return -1;
                } else {
                    return 0;
                }
            });
            int max = elements.get(0).count;

            for (Element element : elements) {
                if (element.count != max) {
                    break;
                } else {
                    results.add(element.id);
                }
            }
        }

        int resultSize = results.size();
        answer = new String[resultSize];

        results.sort((String s1, String s2) -> {
            if (s1.compareTo(s2) > 0) {
                return 1;
            } else if (s1.compareTo(s2) < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < resultSize; i++) {
            answer[i] = results.get(i);
        }


        return answer;
    }

    // nCr
    public void makeCombination(char[] carr, StringBuilder element, int n, int count, int index) {
        if (orderLen < index) {
            return;
        }

        if (count < 2) {
            for (int i = index; i < orderLen; i++) {
                makeCombination(carr, element.append(carr[i]), n, count + 1, i + 1);
                element.deleteCharAt(count);
            }
        } else {
            if (map.getOrDefault(count, null) == null) {
                map.put(count, new HashMap<>());
                Map<String, Element> m = map.get(count);
                String key = element.toString();
                if (m.getOrDefault(key, null) == null) {
                    m.put(key, new Element(key, 1));
                } else {
                    Element e = m.get(key);
                    e.count++;
                    m.replace(key, e);
                }
            } else {
                Map<String, Element> m = map.get(count);
                String key = element.toString();
                if (m.getOrDefault(key, null) == null) {
                    m.put(key, new Element(key, 1));
                } else {
                    Element e = m.get(key);
                    e.count++;
                    m.replace(key, e);
                }
            }

            for (int i = index; i < orderLen; i++) {
                makeCombination(carr, element.append(carr[i]), n, count + 1, i + 1);
                element.deleteCharAt(count);
            }
        }
    }

    class Element {
        String id;
        Integer count;

        public Element(String id, Integer count) {
            this.id = id;
            this.count = count;
        }
    }
}