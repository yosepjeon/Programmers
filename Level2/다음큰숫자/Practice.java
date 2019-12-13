package Level2.다음큰숫자;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		int n;
		Scanner scr = new Scanner(System.in);
		
//		System.out.println(Integer.toBinaryString(n));
		while(true) { 
			n = scr.nextInt();
			if(n == -1)
				break;
			System.out.println(dfs(n,""));
		}
	}
	
	public static String dfs(int n,String result) {
		if(n == 1){
			result = n + result;
			return result;
		}
		
		return dfs(n/2,n%2 + result);
	}
}
