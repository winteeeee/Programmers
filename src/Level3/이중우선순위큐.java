package Level3;

import java.util.*;

class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        var map = new TreeMap<Integer, Integer>();
        for (String operation : operations) {
            var st = new StringTokenizer(operation);
            String operator = st.nextToken();
            int operand = Integer.parseInt(st.nextToken());

            if (operator.equals("I")) {
                map.put(operand, map.getOrDefault(operand, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                int target = operand == 1 ? map.lastKey() : map.firstKey();
                map.put(target, map.get(target) - 1);
                if (map.get(target) == 0)
                    map.remove(target);
            }
        }

        return map.isEmpty() ? new int[]{0, 0} : new int[]{map.lastKey(), map.firstKey()};
    }
}
