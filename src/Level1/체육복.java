package Level1;

import java.util.TreeSet;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        var lostSet = new TreeSet<Integer>();
        var reserveSet = new TreeSet<Integer>();
        for (int lostIdx : lost)
            lostSet.add(lostIdx);
        for (int reserveIdx : reserve)
            reserveSet.add(reserveIdx);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i) && reserveSet.contains(i)) {
                lostSet.remove(i);
                reserveSet.remove(i);
            }

            if (!lostSet.contains(i)) {
                answer++;
            }
        }

        for (int lostIdx : lostSet) {
            if (reserveSet.contains(lostIdx - 1)) {
                answer++;
                reserveSet.remove(lostIdx - 1);
            } else if (reserveSet.contains(lostIdx + 1)) {
                answer++;
                reserveSet.remove(lostIdx + 1);
            }
        }

        return answer;
    }
}