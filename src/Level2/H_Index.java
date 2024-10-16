package Level2;

import java.util.*;

class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            answer = Math.max(answer, Math.min(citation, citations.length - i));
        }

        return answer;
    }
}