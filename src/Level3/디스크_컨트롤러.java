package Level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class 디스크_컨트롤러 {
    class Job implements Comparable<Job> {
        int requestTime;
        int processingTime;

        public Job(int[] arr) {
            this.requestTime = arr[0];
            this.processingTime = arr[1];
        }

        @Override
        public int compareTo(Job o) {
            int comp1 = Integer.compare(processingTime, o.processingTime);
            int comp2 = Integer.compare(requestTime, o.requestTime);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    public int solution(int[][] jobs) {
        Job[] jArr = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jArr[i] = new Job(jobs[i]);
        }
        Arrays.sort(jArr, Comparator.comparingInt(j -> j.requestTime));

        double answer = 0;
        int time = 0;
        var q = new LinkedList<>(Arrays.asList(jArr));
        var h = new PriorityQueue<Job>();
        while (!(q.isEmpty() && h.isEmpty())) {
            if (h.isEmpty() && q.peek().requestTime > time) time = q.peek().requestTime;
            while (!q.isEmpty() && q.peek().requestTime <= time) {
                h.add(q.remove());
            }

            if (!h.isEmpty()) {
                Job cur = h.remove();
                time += cur.processingTime;
                answer += time - cur.requestTime;
            }
        }

        return (int) (answer / jArr.length);
    }
}