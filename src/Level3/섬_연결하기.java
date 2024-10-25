package Level3;

import java.util.*;

class 섬_연결하기 {
    class 집합 {
        int[] 배열;

        집합(int 크기) {
            배열 = new int[크기];
            for (int i = 0; i < 크기; i++) {
                배열[i] = i;
            }
        }

        int 부모탐색(int 인덱스) {
            if (배열[인덱스] == 인덱스)
                return 인덱스;
            return 배열[인덱스] = 부모탐색(배열[인덱스]);
        }

        void 병합(int 부모1, int 부모2) {
            배열[부모2] = 부모1;
        }
    }

    class 간선 implements Comparable<간선> {
        int 섬1;
        int 섬2;
        int 비용;

        간선(int 섬1, int 섬2, int 비용) {
            this.섬1 = 섬1;
            this.섬2 = 섬2;
            this.비용 = 비용;
        }

        @Override
        public int compareTo(간선 간) {
            return Integer.compare(비용, 간.비용);
        }
    }

    public int solution(int n, int[][] costs) {
        집합 집합 = new 집합(n);
        PriorityQueue<간선> 간선들 = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int 비용 = costs[i][2];
            간선들.add(new 간선(a, b, 비용));
        }

        int 답 = 0;
        while (!간선들.isEmpty()) {
            간선 간선 = 간선들.remove();
            int 부모1 = 집합.부모탐색(간선.섬1);
            int 부모2 = 집합.부모탐색(간선.섬2);

            if (부모1 != 부모2) {
                답 += 간선.비용;
                집합.병합(부모1, 부모2);
            }
        }

        return 답;
    }
}