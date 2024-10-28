package Level3;

import java.util.*;

class 단속카메라 {
    class 차량경로 implements Comparable<차량경로> {
        int 진입지점;
        int 진출지점;

        차량경로(int[] 이동경로) {
            진입지점 = 이동경로[0];
            진출지점 = 이동경로[1];
        }

        @Override
        public int compareTo(차량경로 경로) {
            return Integer.compare(진출지점, 경로.진출지점);
        }

        boolean 카메라만남(int 마지막카메라위치) {
            return 진입지점 <= 마지막카메라위치 && 마지막카메라위치 <= 진출지점;
        }
    }

    public int solution(int[][] routes) {
        var 차량경로들 = new 차량경로[routes.length];
        for (int i = 0; i < 차량경로들.length; i++)
            차량경로들[i] = new 차량경로(routes[i]);
        Arrays.sort(차량경로들);

        int 답 = 0;
        int 마지막카메라위치 = Integer.MIN_VALUE;
        for (차량경로 차량경로 : 차량경로들) {
            if (!차량경로.카메라만남(마지막카메라위치)) {
                마지막카메라위치 = 차량경로.진출지점;
                답++;
            }
        }

        return 답;
    }
}