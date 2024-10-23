package Level4;

class 사칙연산 {
    String[] formula;
    int[][] dp;
    int[][] dp2;
    boolean[][] visited;

    public int solution(String arr[]) {
        formula = arr;
        dp = new int[arr.length][arr.length];
        dp2 = new int[arr.length][arr.length];
        visited = new boolean[arr.length][arr.length];

        return findValue(0, arr.length - 1)[0];
    }

    public int[] findValue(int i, int j) {
        if (visited[i][j])
            return new int[]{dp[i][j], dp2[i][j]};

        visited[i][j] = true;
        if (i == j) {
            int value = Integer.parseInt(formula[i]);
            dp[i][j] = value;
            dp2[i][j] = value;
            return new int[]{value, value};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a = i + 1; a <= j - 1; a += 2) {
            char curOperand = formula[a].charAt(0);
            int[] front = findValue(i, a - 1);
            int[] back = findValue(a + 1, j);

            if (curOperand == '+') {
                max = Math.max(max, front[0] + back[0]);
                min = Math.min(min, front[1] + back[1]);
            } else {
                max = Math.max(max, front[0] - back[1]);
                min = Math.min(min, front[1] - back[0]);
            }
        }

        dp[i][j] = max;
        dp2[i][j] = min;
        return new int[]{max, min};
    }
}
