package Level1.비밀지도;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};


        Solution solution = new Solution();
        String[] results = solution.solution(n, arr1, arr2);

        for(int i=0;i<n;i++) {
            System.out.println(results[i]);
        }
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;
        String[] result = new String[n];

        for(int i=0;i<n;i++) {
            StringBuilder strArr1 = new StringBuilder();
            StringBuilder strArr2 = new StringBuilder();
            int n1 = arr1[i];
            int n2 = arr2[i];

            strArr1.append(Integer.toBinaryString(n1));
            while(strArr1.length() < n) {
                strArr1.insert(0, "0");
            }

            strArr2.append(Integer.toBinaryString(n2));
            while (strArr2.length() < n) {
                strArr2.insert(0, "0");
            }

            char[] carr1 = strArr1.toString().toCharArray();
            char[] carr2 = strArr2.toString().toCharArray();

            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++) {
                int c = (carr1[j] - '0') + (carr2[j] - '0');

                if(c == 0) {
                    sb.append(" ");
                }else {
                    sb.append("#");
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }
}