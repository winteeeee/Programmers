package Level3;

import java.util.*;

class 양과_늑대 {
    int 답 = 0;
    int[] 노드정보;
    boolean[] 방문함;
    ArrayList<Integer>[] 간선들;

    public int solution(int[] info, int[][] edges) {
        노드정보 = info;
        방문함 = new boolean[info.length];
        간선들 = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++)
            간선들[i] = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; i++) {
            간선들[edges[i][0]].add(edges[i][1]);
            간선들[edges[i][1]].add(edges[i][0]);
        }

        방문함[0] = true;
        백트래킹(0, 1, 0, new HashSet<Integer>());
        return 답;
    }

    public void 백트래킹(int 노드, int 양, int 늑대, HashSet<Integer> 방문가능노드) {
        if (늑대 >= 양) return;

        for (int 다음노드 : 간선들[노드]) {
            방문가능노드.add(다음노드);
        }

        for (int 다음노드 : 방문가능노드) {
            if (!방문함[다음노드]) {
                int 다음양 = 노드정보[다음노드] == 0 ? 양 + 1 : 양;
                int 다음늑대 = 노드정보[다음노드] == 1 ? 늑대 + 1 : 늑대;

                답 = Math.max(답, 다음양);
                방문함[다음노드] = true;
                백트래킹(다음노드, 다음양, 다음늑대, new HashSet<Integer>(방문가능노드));
                방문함[다음노드] = false;
            }
        }

    }
}