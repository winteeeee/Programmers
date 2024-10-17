package Level0;

import java.util.*;

class 중앙값_구하기 {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}