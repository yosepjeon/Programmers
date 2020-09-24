package Level3.브라이언의고민;

public class Practice2 {
	public static void main(String[] args) {
		String str = "123456789";
		
		System.out.println(str.indexOf("7"));
		System.out.println(str.substring(0,str.indexOf("7")));
		System.out.println(str.substring(str.indexOf("7")));
	}
}
