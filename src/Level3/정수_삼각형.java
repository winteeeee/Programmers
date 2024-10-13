package Level3;

class 정수_삼각형 {
    public int solution(int[][] triangle) {
        final int LENGTH = triangle.length;
        int[][] dp = new int[LENGTH][LENGTH];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < LENGTH; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }

                dp[i][j] += triangle[i][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < LENGTH; i++) {
            answer = Math.max(answer, dp[LENGTH - 1][i]);
        }

        return answer;
    }
}
