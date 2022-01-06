package Level1.음양더하기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] absolutes = {1,2,3};
        boolean[] signs = {false, false, true};

        System.out.println(solution.solution(absolutes, signs));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        int len = absolutes.length;
        for (int i = 0; i < len; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            }else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}