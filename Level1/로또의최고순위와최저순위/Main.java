package Level1.로또의최고순위와최저순위;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};



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
            }
        }

        return 0;
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