package Level5.추석트래픽;

public class Practice {
	public static void main(String[] args ) {
		String str = "item|dropTarget";
		int index = str.indexOf("|");
		
		System.out.println(index);
		System.out.println(str.substring(0,index));
		System.out.println(str.substring(index+1,str.length()));
	}
}
