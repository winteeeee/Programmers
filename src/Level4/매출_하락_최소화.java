package Level4;

import java.util.*;

class 매출_하락_최소화 {
    int[][] dp;
    직원[] 직원들;

    class 직원 implements Comparable<직원> {
        int 직원번호;
        int 매출액;
        직원 팀장 = null;
        ArrayList<직원> 팀원 = new ArrayList<>();

        직원(int 직원번호, int 매출액) {
            this.직원번호 = 직원번호;
            this.매출액 = 매출액;
        }

        @Override
        public int compareTo(직원 직원) {
            int comp1 = Integer.compare(매출액, 직원.매출액);
            int comp2 = Integer.compare(직원번호, 직원.직원번호);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    public int solution(int[] 매출액들, int[][] 직원관계들) {
        dp = new int[매출액들.length + 1][2];
        직원들 = new 직원[매출액들.length + 1];
        for (int i = 1; i <= 매출액들.length; i++)
            직원들[i] = new 직원(i, 매출액들[i - 1]);
        for (int[] 직원관계 : 직원관계들) {
            직원들[직원관계[0]].팀원.add(직원들[직원관계[1]]);
            직원들[직원관계[1]].팀장 = 직원들[직원관계[0]];
        }

        테이블_채우기(1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    public void 테이블_채우기(int 인덱스) {
        if (직원들[인덱스].팀원.isEmpty()) {
            dp[인덱스][0] = 0;
            dp[인덱스][1] = 직원들[인덱스].매출액;
            return;
        }

        int 직원_매출액_최솟값 = 0;
        for (직원 팀원 : 직원들[인덱스].팀원) {
            테이블_채우기(팀원.직원번호);
            직원_매출액_최솟값 += Math.min(dp[팀원.직원번호][0], dp[팀원.직원번호][1]);
        }

        int 팀원_참가_매출액_최솟값 = Integer.MAX_VALUE;
        for (int i = 0; i < 직원들[인덱스].팀원.size(); i++) {
            int 임시_최솟값 = 0;
            for (int j = 0; j < 직원들[인덱스].팀원.size(); j++) {
                직원 현재직원 = 직원들[인덱스].팀원.get(j);
                임시_최솟값 += i == j ? dp[현재직원.직원번호][1] : Math.min(dp[현재직원.직원번호][0], dp[현재직원.직원번호][1]);
            }
            팀원_참가_매출액_최솟값 = Math.min(팀원_참가_매출액_최솟값, 임시_최솟값);
        }

        dp[인덱스][0] = 팀원_참가_매출액_최솟값;
        dp[인덱스][1] = 직원_매출액_최솟값 + 직원들[인덱스].매출액;
    }
}