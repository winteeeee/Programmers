package Level3;

import java.util.*;

class 최고의_집합 {
    public int[] solution(int n, int s) {
        int[] 답;
        int 베이스값 = s / n;
        int 모듈러값 = s % n;

        if (베이스값 != 0) {
            답 = new int[n];
            for (int i = 0; i < n - 모듈러값; i++)
                답[i] = 베이스값;
            for (int i = n - 모듈러값; i < n; i++)
                답[i] = 베이스값 + 1;
        } else {
            답 = new int[1];
            답[0] = -1;
        }

        return 답;
    }
}
