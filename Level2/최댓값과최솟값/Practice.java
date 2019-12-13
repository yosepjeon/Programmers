package Level2.최댓값과최솟값;

public class Practice {
	public static void main(String[] args) {
		String s = "3 5 7";
		
		System.out.println(s.indexOf(" "));
		System.out.println(s.substring(0,s.indexOf(" ")));
		String s2 = s.substring(0,s.indexOf(" "));
		System.out.println(s2);
	}
}


