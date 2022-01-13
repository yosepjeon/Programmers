package Level1.없는숫자더하기;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};

        Solution solution = new Solution();

        System.out.println(solution.solution(numbers));
    }
}

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] checkArr = new boolean[10];

        for(int number : numbers) {
            checkArr[number] = true;
        }

        for(int i=0;i<10;i++) {
            if(!checkArr[i]) {
                answer += i;
            }
        }

        return answer;
    }
}