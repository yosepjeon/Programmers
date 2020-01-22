package Level3.단어변환;

public class Practice {
	public static void main(String[] args) {
		String str1 = "hit";
		String str2 = "hot";
		String str3 = "dot";
		
		str1.matches("h.t");
		System.out.println(str1.matches("h.t"));
		
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.compareTo(str3));
	}
}
