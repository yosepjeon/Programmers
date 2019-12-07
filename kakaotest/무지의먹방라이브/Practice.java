package kakaotest.무지의먹방라이브;

import java.util.LinkedList;
import java.util.List;

public class Practice {
	public static void main(String[] args ) {
		List<Num> list = new LinkedList<Num>();
		
		list.add(new Num(1));
		list.add(new Num(2));
		list.add(new Num(3));
		
		
		System.out.println(list.get(1));
	}
}

class Num {
	int i;
	
	public Num(int i) {
		this.i = i;
	}
}