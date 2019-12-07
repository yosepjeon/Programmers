package Level2.가장큰수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Practice {
	
	public static void main(String[] args ) {
		ArrayList<Integer> list =  new ArrayList<>();
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		
		for(int i=0;i<n;i++) {
			int num = scr.nextInt();
			list.add(num);
		}
		
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2) {
					return 1;
				}else if(o1<o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		for(int elem : list) {
			System.out.print(elem + " ");
		}
	}
}
