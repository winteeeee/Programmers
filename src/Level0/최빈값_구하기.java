package Level0;

import java.util.*;

class 최빈값_구하기 {
    public int solution(int[] array) {
        var map = new HashMap<Integer, Integer>();
        for (int e : array) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int answer = 0;
        int prevValue = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (prevValue < e.getValue()) {
                prevValue = e.getValue();
                answer = Math.max(answer, e.getKey());
            } else if (prevValue == e.getValue()) {
                answer = -1;
            }
        }

        return answer;
    }
}