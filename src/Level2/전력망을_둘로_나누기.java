package Level2;

import java.util.*;

class 전력망을_둘로_나누기 {
    class 분리집합 {
        int[] 배열;

        분리집합(int 크기) {
            배열 = new int[크기];
            for (int i = 0; i < 크기; i++) {
                배열[i] = i;
            }
        }

        int 부모찾기(int 자식) {
            if (배열[자식] == 자식) return 자식;
            return 배열[자식] = 부모찾기(배열[자식]);
        }

        void 병합(int 부모1, int 부모2) {
            배열[부모1] = 부모2;
        }

        HashSet<Integer> 부모집합() {
            var 부모집합 = new HashSet<Integer>();
            for (int 자식 : 배열) {
                int 부모 = 부모찾기(자식);
                if (부모 != 0)
                    부모집합.add(부모찾기(자식));
            }

            return 부모집합;
        }

        int 집합크기(int 부모) {
            int 크기 = 0;
            for (int 자식 : 배열)
                if (부모찾기(자식) == 부모)
                    크기++;

            return 크기;
        }
    }

    public int solution(int n, int[][] wires) {
        int 답 = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            var 분리집합 = new 분리집합(n + 1);

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int 부모1 = 분리집합.부모찾기(wires[j][0]);
                int 부모2 = 분리집합.부모찾기(wires[j][1]);
                분리집합.병합(부모1, 부모2);
            }

            int 송전탑차이 = 0;
            var 부모집합 = 분리집합.부모집합();
            for (int 부모 : 부모집합) {
                int 집합크기 = 분리집합.집합크기(부모);
                송전탑차이 += 송전탑차이 == 0 ? 집합크기 : -집합크기;
            }

            답 = Math.min(답, Math.abs(송전탑차이));
        }

        return 답;
    }
}