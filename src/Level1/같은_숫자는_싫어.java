package Level1;

import java.util.*;

class 같은_숫자는_싫어 {
    public static int[] solution(int[] arr) {
        var s = new Stack<Integer>();
        s.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (s.peek() != arr[i]) {
                s.push(arr[i]);
            }
        }

        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}