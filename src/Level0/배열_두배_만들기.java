package Level0;

import java.util.*;

class 배열_두배_만들기 {
    public ArrayList<Integer> solution(int[] numbers) {
        var answer = new ArrayList<Integer>();
        for (int number : numbers)
            answer.add(number * 2);

        return answer;
    }
}