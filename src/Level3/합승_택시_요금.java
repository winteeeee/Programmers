package Level3;

import java.util.*;

class 합승_택시_요금 {
    public int solution(int 지점개수, int 출발지점, int a도착지점, int b도착지점, int[][] 요금들) {
        int[][] 최단거리 = 플로이드_워셜(지점개수, 요금들);
        int 답 = Integer.MAX_VALUE;
        for (int 합승지점 = 1; 합승지점 <= 지점개수; 합승지점++) {
            답 = Math.min(최단거리[출발지점][합승지점] + 최단거리[합승지점][a도착지점] + 최단거리[합승지점][b도착지점], 답);
        }

        return 답;
    }

    public int[][] 플로이드_워셜(int 지점개수, int[][] 요금들) {
        int[][] 최단거리 = new int[지점개수 + 1][지점개수 + 1];
        for (int i = 1; i <= 지점개수; i++)
            for (int j = 1; j <= 지점개수; j++)
                if (i != j)
                    최단거리[i][j] = 1000000;

        for (int i = 0; i < 요금들.length; i++) {
            int 지점1 = 요금들[i][0];
            int 지점2 = 요금들[i][1];
            int 요금 = 요금들[i][2];

            최단거리[지점1][지점2] = 요금;
            최단거리[지점2][지점1] = 요금;
        }

        for (int 경유지 = 1; 경유지 <= 지점개수; 경유지++) {
            for (int 지점1 = 1; 지점1 <= 지점개수; 지점1++) {
                for (int 지점2 = 1; 지점2 <= 지점개수; 지점2++) {
                    최단거리[지점1][지점2] = Math.min(최단거리[지점1][지점2], 최단거리[지점1][경유지] + 최단거리[경유지][지점2]);
                }
            }
        }

        return 최단거리;
    }
}