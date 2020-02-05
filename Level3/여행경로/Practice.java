package Level3.여행경로;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice {
	public static void main(String[] args ) {
		StringBuffer sb = checkStringBufferInRecursive(1, new StringBuffer().append("1 "));
	
		System.out.println(sb.toString());
	}
	
	public static StringBuffer checkStringBufferInRecursive(int num,StringBuffer sb) {
		if(num >= 10 )
			return sb;
		
		if(num % 2 == 0) {
			return checkStringBufferInRecursive(num+1, sb.append(num+1 + " "));
		}else {
			return checkStringBufferInRecursive(num+1, sb.append(num+1 + " "));
		}
	}
}
