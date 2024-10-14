package Level4;

import java.util.*;

class 징검다리 {
    final boolean DEBUG = false;

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        var distances = new ArrayList<Integer>();
        for (int i = 0; i <= rocks.length; i++) {
            if (i == 0) {
                distances.add(rocks[i]);
            } else {
                int rock = i != rocks.length ? rocks[i] : distance;
                distances.add(rock - rocks[i - 1]);
            }
        }

        int start = 0;
        int end = distance;
        int mid = (start + end) / 2;
        int answer = 0;

        while (start <= end) {
            if (DEBUG) System.out.println("현재 mid : " + mid);
            int count = getCount(mid, distances);
            if (DEBUG) System.out.println("카운트: " + count);

            if (count > n) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                if (count <= n) answer = Math.max(answer, mid);
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }

        return answer;
    }

    public int getCount(int target, ArrayList<Integer> distances) {
        int result = 0;
        int distance = 0;
        for (int i = 0; i < distances.size(); i++) {
            int d = distances.get(i);
            distance += d;
            if (DEBUG) System.out.print("현재 distance: " + distance);

            if (distance < target) {
                if (DEBUG) System.out.println(" 바위 제거 O");
                result++;
            } else {
                if (DEBUG) System.out.println(" 바위 제거 X");
                distance = 0;
            }
        }

        return result;
    }
}