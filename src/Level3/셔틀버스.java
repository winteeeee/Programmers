package Level3;

import java.util.*;

class 셔틀버스 {
    class 시간 implements Comparable<시간> {
        int 시;
        int 분;

        시간(String 시간문자열) {
            String[] 시간정보 = 시간문자열.split(":");
            시 = Integer.parseInt(시간정보[0]);
            분 = Integer.parseInt(시간정보[1]);
        }

        void 시간증가(int 증분) {
            분 += 증분;
            if (분 >= 60) {
                시++;
                분 %= 60;
            }
        }

        void 시간감소(int 감분) {
            분 -= 감분;
            if (분 < 0) {
                분 += 60;
                시--;
            }
        }

        @Override
        public int compareTo(시간 시간) {
            int comp1 = Integer.compare(시, 시간.시);
            int comp2 = Integer.compare(분, 시간.분);
            return comp1 != 0 ? comp1 : comp2;
        }

        @Override
        public String toString() {
            String 시문자열 = String.valueOf(시);
            String 분문자열 = String.valueOf(분);
            if (시문자열.length() == 1) 시문자열 = "0" + 시문자열;
            if (분문자열.length() == 1) 분문자열 = "0" + 분문자열;

            return 시문자열 + ":" + 분문자열;
        }
    }

    public String solution(int 운행횟수, int 운행간격, int 최대탑승인원, String[] 시간표) {
        Arrays.sort(시간표);
        var 대기큐 = new LinkedList<시간>();
        for (String 도착시간 : 시간표)
            대기큐.add(new 시간(도착시간));

        시간 답 = null;
        var 버스시간 = new 시간("09:00");
        for (int i = 0; i < 운행횟수; i++, 버스시간.시간증가(운행간격)) {
            int 카운트 = 0;
            var 도착시간 = new TreeSet<시간>();
            while (!대기큐.isEmpty() && 버스시간.compareTo(대기큐.peekFirst()) >= 0 && 카운트 < 최대탑승인원) {
                도착시간.add(대기큐.removeFirst());
                카운트++;
            }

            if (카운트 == 최대탑승인원) {
                var 목표크루 = 도착시간.size() == 1 ? 도착시간.first() : 도착시간.last();
                답 = new 시간(목표크루.toString());
                답.시간감소(1);
            } else if (카운트 < 최대탑승인원) {
                답 = new 시간(버스시간.toString());
            }
        }

        return 답.toString();
    }
}
