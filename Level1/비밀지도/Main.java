package Level1.비밀지도;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String b1 = Integer.toBinaryString(arr1[0]);
        String b2 = Integer.toBinaryString(arr2[0]);
        String b3 = Integer.toBinaryString(arr1[0] + arr2[0]);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Solution solution = new Solution();
//        System.out.println(solution.solution(n, arr1, arr2));
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;
        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];

        for(int i=0;i<n;i++) {
            int n1 = arr1[i];
            int n2 = arr2[i];

            strArr1[i] = Integer.toBinaryString(n1);
            strArr2[i] = Integer.toBinaryString(n2);


        }

        return null;
    }
}