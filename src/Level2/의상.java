package Level2;

import java.util.*;

class 의상 {
    public int solution(String[][] clothes) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 1) + 1);
        }

        int answer = 1;
        for (int v : map.values()) {
            answer *= v;
        }

        return answer - 1;
    }
}