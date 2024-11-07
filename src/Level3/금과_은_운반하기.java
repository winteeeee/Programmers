package Level3;

class 금과_은_운반하기 {
    public long solution(int 금목표, int 은목표, int[] 금들, int[] 은들, int[] 운반량, int[] 운반시간) {
        long 시작 = 0;
        long 끝 = 1000000000000000L;
        long 시간 = 끝 / 2;

        while (시작 <= 끝) {
            long 금운반량 = 단일운반량(시간, 금들, 운반량, 운반시간);
            long 은운반량 = 단일운반량(시간, 은들, 운반량, 운반시간);
            long 전체운반량 = 전체운반량(시간, 금들, 은들, 운반량, 운반시간);

            if (금운반량 < 금목표 || 은운반량 < 은목표 || 전체운반량 < 금목표 + 은목표)
                시작 = 시간 + 1;
            else
                끝 = 시간 - 1;

            시간 = 시작 + (끝 - 시작) / 2;
        }

        return 시간;
    }

    public long 단일운반량(long 시간, int[] 광물, int[] 운반량, int[] 운반시간) {
        long 답 = 0;
        for (int i = 0; i < 광물.length; i++) {
            long 운반가능량 = 운반량[i] * (시간 / (운반시간[i] * 2));
            if (시간 % (운반시간[i] * 2) >= 운반시간[i])
                운반가능량 += 운반량[i];
            답 += Math.min(광물[i], 운반가능량);
        }

        return 답;
    }

    public long 전체운반량(long 시간, int[] 금, int[] 은, int[] 운반량, int[] 운반시간) {
        long 답 = 0;
        for (int i = 0; i < 금.length; i++) {
            long 운반가능량 = 운반량[i] * (시간 / (운반시간[i] * 2));
            if (시간 % (운반시간[i] * 2) >= 운반시간[i])
                운반가능량 += 운반량[i];
            답 += Math.min(금[i] + 은[i], 운반가능량);
        }

        return 답;
    }
}