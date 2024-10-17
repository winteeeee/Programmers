package Level0;

import java.util.*;

class 짝수는_싫어요 {
    public ArrayList<Integer> solution(int n) {
        var answer = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 1) {
                answer.add(i);
            }
        }

        return answer;
    }
}