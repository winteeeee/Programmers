package Level1;

import java.util.*;

class 모의고사 {
    public ArrayList<Integer> solution(int[] answers) {
        var answer = new ArrayList<Integer>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i])
                oneCount++;
            if (two[i % two.length] == answers[i])
                twoCount++;
            if (three[i % three.length] == answers[i])
                threeCount++;
        }

        int max = Math.max(oneCount, Math.max(twoCount, threeCount));
        if (oneCount == max)
            answer.add(1);
        if (twoCount == max)
            answer.add(2);
        if (threeCount == max)
            answer.add(3);

        return answer;
    }
}