package Level1.로또의최고순위와최저순위;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(6,1);
        rankMap.put(5,2);
        rankMap.put(4,3);
        rankMap.put(3,4);
        rankMap.put(2,5);
        rankMap.put(1,6);

        int maxScore = getMaxScore(lottos, win_nums);
        int minScore = getMinScore(lottos, win_nums);

        answer[0] = rankMap.getOrDefault(maxScore, 6);
        answer[1] = rankMap.getOrDefault(minScore, 6);

        return answer;
    }

    public static int getMaxScore(int[] lottos, int[] win_nums) {
        int score = 0;
        Map<Integer, Number> winNumberMap = new HashMap<>();

        for(int winNum : win_nums) {
            winNumberMap.put(winNum, new Number(winNum));
        }

        for(int lotto : lottos) {
            Number number = winNumberMap.getOrDefault(lotto, null);
            if(number != null && !number.isCheck) {
                number.setCheck(true);
                score++;
                continue;
            }

            if(lotto == 0) {
                score++;
            }
        }

        return score;
    }

    public static int getMinScore(int[] lottos, int[] win_nums) {
        int score = 0;
        Map<Integer, Number> winNumberMap = new HashMap<>();

        for(int winNum : win_nums) {
            winNumberMap.put(winNum, new Number(winNum));
        }

        for(int lotto : lottos) {
            Number number = winNumberMap.getOrDefault(lotto, null);
            if(number != null && !number.isCheck) {
                number.setCheck(true);
                score++;
                continue;
            }

            if(lotto == 0) {
                continue;
            }
        }

        return score;
    }

    static class Number {
        boolean isCheck = false;
        int number = 0;

        public Number(int number) {
            this.number = number;
        }

        public void setCheck(boolean isCheck) {
            this.isCheck = isCheck;
        }
    }
}