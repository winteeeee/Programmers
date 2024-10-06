package Level2;

import java.util.PriorityQueue;

class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        var h = new PriorityQueue<Integer>();
        for (int s : scoville) h.add(s);
        while (h.peek() < K) {
            if (h.size() == 1) return -1;
            answer++;
            h.add(h.remove() + h.remove() * 2);
        }

        return answer;
    }
}