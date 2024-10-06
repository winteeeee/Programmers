package Level1;

import java.util.ArrayList;
import java.util.Arrays;

class K번쨰수 {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        var answer = new ArrayList<Integer>();
        for (int i = 0; i < commands.length; i++) {
            int splitStart = commands[i][0] - 1;
            int splitEnd = commands[i][1];
            int targetIdx = splitStart + commands[i][2] - 1;

            int[] tempArr = array.clone();
            Arrays.sort(tempArr, splitStart, splitEnd);
            answer.add(tempArr[targetIdx]);
        }

        return answer;
    }
}