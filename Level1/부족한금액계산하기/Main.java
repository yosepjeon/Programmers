package Level1.부족한금액계산하기;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long totalPrice = 0;

        for(int i=1;i<=count;i++) {
            totalPrice += price * i;
        }
        answer = money - totalPrice;

        return answer >= 0 ? 0 : answer * -1;
    }
}