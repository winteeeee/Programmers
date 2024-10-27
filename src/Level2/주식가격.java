package Level2;

import java.util.*;

class 주식가격 {
    class 주식 {
        int 가격;
        int 시간;

        주식(int 가격, int 시간) {
            this.가격 = 가격;
            this.시간 = 시간;
        }
    }

    public int[] solution(int[] prices) {
        var 답 = new int[prices.length];
        var 스택 = new Stack<주식>();
        for (int i = 0; i < prices.length; i++) {
            int 가격 = prices[i];

            while (!스택.isEmpty() && 스택.peek().가격 > 가격) {
                주식 주식 = 스택.pop();
                답[주식.시간] = i - 주식.시간;
            }
            스택.push(new 주식(가격, i));
        }

        while (!스택.isEmpty()) {
            주식 주식 = 스택.pop();
            답[주식.시간] = prices.length - 1 - 주식.시간;
        }

        return 답;
    }
}