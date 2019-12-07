package kakaotest.후보키;

import java.util.LinkedList;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		Value key1 = new Value();
		Value key2 = new Value();
		
		key1.list.add(1);
		key1.list.add(2);
		
		key2.list.add(1);
		key2.list.add(2);
		
		if(key1.list.equals(key2.list)) {
			System.out.println("equal");
		}else {
			System.out.println("different");
		}
	}
}

class Value {
	LinkedList<Integer> list;
	
	public Value() {
		this.list = new LinkedList<>();
	}
}
