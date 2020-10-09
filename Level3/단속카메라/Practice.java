package Level3.단속카메라;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		int count = 0; 
		while(!list.isEmpty()) {
			int n1 = list.get(0);
			count++;
			Iterator<Integer> itr = list.iterator();
			
			while(itr.hasNext()) {
				int n2 = itr.next();
				
				if(n1 <= n2) {
					itr.remove();
				}
			}
		}
		
		System.out.println(count);
	}
}
