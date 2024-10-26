package Level3;

import java.util.*;

class 아이템_줍기 {
    int 답 = Integer.MAX_VALUE;
    좌표 아이템;
    직사각형[] 직사각형들;
    TreeSet<좌표>[] 둘레좌표들;
    TreeSet<좌표> 방문함 = new TreeSet<좌표>();

    class 좌표 implements Comparable<좌표> {
        int x;
        int y;

        좌표(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean 이동가능(좌표 지형, 직사각형 직사각형) {
            int x변화량 = Math.abs(x - 지형.x);
            boolean x위 = (지형.x == 직사각형.좌측하단.x) || (지형.x == 직사각형.우측상단.x);
            int y변화량 = Math.abs(y - 지형.y);
            boolean y위 = (지형.y == 직사각형.좌측하단.y) || (지형.y == 직사각형.우측상단.y);

            return (x변화량 == 1 && y변화량 == 0 && y위) || (x변화량 == 0 && y변화량 == 1 && x위);
        }

        @Override
        public int compareTo(좌표 좌표) {
            int comp1 = Integer.compare(x, 좌표.x);
            int comp2 = Integer.compare(y, 좌표.y);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    class 직사각형 {
        좌표 좌측하단;
        좌표 우측상단;

        직사각형(int[] 배열) {
            좌측하단 = new 좌표(배열[0], 배열[1]);
            우측상단 = new 좌표(배열[2], 배열[3]);
        }

        boolean 포함(좌표 좌표) {
            return (좌측하단.x < 좌표.x && 좌표.x < 우측상단.x) && (좌측하단.y < 좌표.y && 좌표.y < 우측상단.y);
        }

        TreeSet<좌표> 둘레좌표구하기() {
            var 둘레좌표들 = new TreeSet<좌표>();
            int x = 좌측하단.x;
            int y = 좌측하단.y;

            for (; y < 우측상단.y; y++)
                둘레좌표들.add(new 좌표(x, y));
            for (; x < 우측상단.x; x++)
                둘레좌표들.add(new 좌표(x, y));
            for (; y > 좌측하단.y; y--)
                둘레좌표들.add(new 좌표(x, y));
            for (; x > 좌측하단.x; x--)
                둘레좌표들.add(new 좌표(x, y));

            return 둘레좌표들;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        아이템 = new 좌표(itemX, itemY);
        직사각형들 = new 직사각형[rectangle.length];
        for (int i = 0; i < 직사각형들.length; i++) {
            직사각형들[i] = new 직사각형(rectangle[i]);
        }

        둘레좌표들 = new TreeSet[직사각형들.length];
        for (int i = 0; i < 직사각형들.length; i++) {
            둘레좌표들[i] = 직사각형들[i].둘레좌표구하기();
        }

        좌표 캐릭터 = new 좌표(characterX, characterY);
        int 직사각형인덱스 = 0;
        for (int i = 0; i < 직사각형들.length; i++) {
            if (둘레좌표들[i].contains(캐릭터)) {
                깊이우선탐색(캐릭터, i, -1, 0);
            }
        }

        return 답;
    }

    public void 깊이우선탐색(좌표 캐릭터, int 직사각형인덱스, int 이전직사각형인덱스, int 깊이) {
        if (캐릭터.compareTo(아이템) == 0) {
            답 = Math.min(답, 깊이);
            return;
        }

        방문함.add(캐릭터);
        for (좌표 둘레좌표 : 둘레좌표들[직사각형인덱스]) {
            if (!방문함.contains(둘레좌표) && 캐릭터.이동가능(둘레좌표, 직사각형들[직사각형인덱스]) && !내부좌표(둘레좌표) && 바깥회전(둘레좌표, 직사각형인덱스, 이전직사각형인덱스)) {
                int 다른직사각형인덱스 = 접함(둘레좌표, 직사각형인덱스);
                if (다른직사각형인덱스 == -1) {
                    깊이우선탐색(둘레좌표, 직사각형인덱스, 직사각형인덱스, 깊이 + 1);
                } else {
                    깊이우선탐색(둘레좌표, 다른직사각형인덱스, 직사각형인덱스, 깊이 + 1);
                }
            }
        }
    }

    public boolean 바깥회전(좌표 좌표, int 현재직사각형인덱스, int 이전직사각형인덱스) {
        if (이전직사각형인덱스 == -1) return true;
        if (현재직사각형인덱스 == 이전직사각형인덱스) return true;
        return !둘레좌표들[이전직사각형인덱스].contains(좌표);
    }

    public boolean 내부좌표(좌표 좌표) {
        for (int i = 0; i < 직사각형들.length; i++) {
            if (직사각형들[i].포함(좌표)) {
                return true;
            }
        }

        return false;
    }

    public int 접함(좌표 다음좌표, int 직사각형인덱스) {
        for (int i = 0; i < 직사각형들.length; i++) {
            if(i == 직사각형인덱스) continue;
            if (둘레좌표들[i].contains(다음좌표)) {
                return i;
            }
        }

        return -1;
    }
}