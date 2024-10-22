package Level2;

import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {
        var minH = new PriorityQueue<Integer>();
        var maxH = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < people.length; i++) {
            int cur = people[i];

            if (cur > limit / 2) {
                maxH.add(cur);
            } else {
                minH.add(cur);
            }
        }

        int answer = 0;
        while (!(maxH.isEmpty() || minH.isEmpty())) {
            answer++;
            if (maxH.peek() + minH.peek() > limit) {
                maxH.remove();
            } else {
                minH.remove();
                maxH.remove();
            }
        }

        answer += maxH.size();
        answer += minH.size() % 2 == 0 ? minH.size() / 2 : minH.size() / 2 + 1;
        return answer;
    }
}
