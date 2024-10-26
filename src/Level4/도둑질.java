package Level4;

class 도둑질 {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];
        dp[0][0] = 0; dp[1][0] = money[0];
        dp[0][1] = money[0]; dp[1][1] = money[1];

        int 답 = 0;
        for (int i = 2; i < money.length - 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + money[i];
            답 = Math.max(답, Math.max(dp[0][i], dp[1][i]));
        }

        dp = new int[2][money.length];
        dp[0][0] = 0; dp[1][0] = 0;
        dp[0][1] = 0; dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + money[i];
            답 = Math.max(답, Math.max(dp[0][i], dp[1][i]));
        }

        return 답;
    }
}