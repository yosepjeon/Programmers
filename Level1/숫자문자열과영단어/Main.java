package Level1.숫자문자열과영단어;

public class Main {
    public static void main(String[] args) {
//        String s = "1zerotwozero3";
//        String s = "one4seveneight";
//        String s = "23four5six7";
//        String s = "2three45sixseven";
        String s = "123";

        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        String str = s;
        str = str.replace("zero","0");
        str = str.replace("one","1");
        str = str.replace("two","2");
        str = str.replace("three","3");
        str = str.replace("four","4");
        str = str.replace("five","5");
        str = str.replace("six","6");
        str = str.replace("seven","7");
        str = str.replace("eight","8");
        str = str.replace("nine","9");


        return Integer.valueOf(str);
    }
}
