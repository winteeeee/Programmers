package Level3;

import java.util.Arrays;

class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long start = 0;
        long end = (long) n * times[times.length - 1];
        long mid = (start + end) / 2;

        while (start <= end) {
            long sum = 0;
            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return answer;
    }
}