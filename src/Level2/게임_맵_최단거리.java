package Level2;

import java.util.*;

class 게임_맵_최단거리 {
    class Status {
        int r;
        int c;
        int count;

        Status(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int rMax;
    int cMax;
    Queue<Status> q = new LinkedList<>();
    boolean[][] visited;

    public int solution(int[][] maps) {
        rMax = maps.length;
        cMax = maps[0].length;
        visited = new boolean[rMax][cMax];

        q.add(new Status(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Status cur = q.remove();
            if (cur.r == rMax - 1 && cur.c == cMax - 1) return cur.count;

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (boundaryCheck(nextR, nextC) && maps[nextR][nextC] != 0 && !visited[nextR][nextC]) {
                    q.add(new Status(nextR, nextC, cur.count + 1));
                    visited[nextR][nextC] = true;
                }
            }
        }

        return -1;
    }

    public boolean boundaryCheck(int r, int c) {
        return (0 <= r && r < rMax) && (0 <= c && c < cMax);
    }
}