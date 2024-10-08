package Level3;

import java.util.HashSet;

class N으로_표현 {
    public int solution(int N, int number) {
        HashSet<Integer>[] dp = new HashSet[9];
        for (int i = 0; i < 9; i++)
            dp[i] = new HashSet<>();

        dp[1].add(N);
        for (int i = 2; i < 9; i++) {
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(b - a);
                        dp[i].add(a * b);
                        if (b != 0)
                            dp[i].add(a / b);
                        if (a != 0)
                            dp[i].add(b / a);
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++)
            if (dp[i].contains(number))
                return i;

        return -1;
    }
}