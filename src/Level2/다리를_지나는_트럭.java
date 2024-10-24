package Level2;

import java.util.*;

class 다리를_지나는_트럭 {
    class 다리 {
        LinkedList<Integer> 큐;
        int 길이제한;
        int 무게제한;
        int 무게총합;
        int 트럭수;

        다리(int 길이제한, int 무게제한) {
            this.길이제한 = 길이제한;
            this.무게제한 = 무게제한;

            큐 = new LinkedList<>();
            무게총합 = 0;
            트럭수 = 0;
        }

        boolean 추가가능여부(int 트럭) {
            if (큐.size() == 길이제한 && 큐.peek() != -1) {
                return 무게제한 >= 무게총합 - 큐.peek() + 트럭;
            } else {
                return 무게제한 >= 무게총합 + 트럭;
            }
        }

        void 추가(int 트럭) {
            if (큐.size() == 길이제한) {
                건너기();
            }

            큐.add(트럭);
            무게총합 += 트럭;
            트럭수++;
        }

        void 이동() {
            if (큐.size() == 길이제한) {
                건너기();
            }

            큐.add(-1);
        }

        void 건너기() {
            int 값 = 큐.remove();
            if (값 != -1) {
                무게총합 -= 값;
                트럭수--;
            }
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        다리 다리 = new 다리(bridge_length, weight);
        var 대기큐 = new LinkedList<Integer>();
        for (int t : truck_weights)
            대기큐.add(t);

        int 시간 = 0;
        while (!대기큐.isEmpty()) {
            if (다리.추가가능여부(대기큐.peek())) {
                다리.추가(대기큐.remove());
            } else {
                다리.이동();
            }
            시간++;
        }

        while (다리.트럭수 != 0) {
            다리.이동();
            시간++;
        }

        return 시간;
    }
}