package Level2.메뉴리뉴얼;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Element> pq = new PriorityQueue<>((Element e1, Element e2) -> {
            if(e1.count < e2.count) {
                return 1;
            }else if(e1.count > e2.count) {
                return -1;
            }else {
                return 0;
            }
        });
        Map<String, Element> map = new HashMap<>();

        for(int i=0;i<10;i++) {
            Element e = new Element("e" + i, i);
            map.put("e" + i, e);
            pq.add(e);
        }

        Element e = map.get("e0");
        e.count += 20;
        map.replace("e0", e);

        Element element = pq.peek();
//        System.out.println("id: " + element.id + " count: " + element.count);
        pq.forEach(c -> System.out.println("id: " + c.id + " count: " + c.count));
//        pq.stream().peek(c -> System.out.println("id: " + c.id + " count: " + c.count));
    }
}

class Element {
    String id;
    int count;

    public Element(String id, int count) {
        this.id = id;
        this.count = count;
    }
}
