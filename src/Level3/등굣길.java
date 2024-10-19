package Level3;

class 등굣길 {
    int rMax;
    int cMax;
    int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        rMax = n;
        cMax = m;

        dp = new int[rMax + 1][cMax + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((i == 1 && j == 1) || puddlesFind(puddles, i, j)) continue;
                dp[i][j] = (getOrDefault(i - 1, j) % MOD + getOrDefault(i, j - 1) % MOD) % MOD;
            }
        }

        return dp[rMax][cMax] % MOD;
    }

    public boolean puddlesFind(int[][] puddles, int r, int c) {
        for (int i = 0; i < puddles.length; i++) {
            if (puddles[i][1] == r && puddles[i][0] == c)
                return true;
        }

        return false;
    }

    public int getOrDefault(int i, int j) {
        if ((1 <= i && i <= rMax) && (1 <= j && j <= cMax)) {
            return dp[i][j];
        } else {
            return 0;
        }
    }
}