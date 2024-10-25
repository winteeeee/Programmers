package Level2;

class 피로도 {
    int 답;
    던전[] 던전들;
    boolean[] 방문함;

    class 던전 {
        int 최소필요피로도;
        int 소모피로도;

        던전(int 최, int 소) {
            최소필요피로도 = 최;
            소모피로도 = 소;
        }

        boolean 입장가능(int 피로도) {
            return 최소필요피로도 <= 피로도;
        }
    }

    public int solution(int k, int[][] dungeons) {
        던전들 = new 던전[dungeons.length];
        방문함 = new boolean[dungeons.length];

        for (int i = 0; i < 던전들.length; i++) {
            던전들[i] = new 던전(dungeons[i][0], dungeons[i][1]);
        }

        완전탐색(0, 0, k);
        return 답;
    }

    public void 완전탐색(int 던전카운트, int 깊이, int 현재피로도) {
        if (깊이 == 던전들.length) {
            답 = Math.max(답, 던전카운트);
            return;
        }

        for (int i = 0; i < 던전들.length; i++) {
            if (!방문함[i]) {
                방문함[i] = true;
                if (던전들[i].입장가능(현재피로도)) {
                    완전탐색(던전카운트 + 1, 깊이 + 1, 현재피로도 - 던전들[i].소모피로도);
                } else {
                    완전탐색(던전카운트, 깊이 + 1, 현재피로도);
                }
                방문함[i] = false;
            }
        }
    }
}