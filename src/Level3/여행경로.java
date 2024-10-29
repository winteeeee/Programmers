package Level3;

import java.util.*;

class 여행경로 {
    HashMap<String, HashMap<String, Integer>> 간선;
    class 여행경로2 {
        ArrayList<String> 방문경로;
        HashMap<String, HashMap<String, Integer>> 방문함;

        여행경로2(String 현위치) {
            방문경로 = new ArrayList<String>();
            방문경로.add(현위치);
            방문함 = new HashMap<String, HashMap<String, Integer>>();
        }

        여행경로2(여행경로2 경로) {
            방문경로 = new ArrayList<String>();
            for (String 공항 : 경로.방문경로)
                방문경로.add(공항);

            방문함 = new HashMap<String, HashMap<String, Integer>>();
            for (Map.Entry<String, HashMap<String, Integer>> 요소 : 경로.방문함.entrySet()) {
                String 출발지 = 요소.getKey();
                if (!방문함.containsKey(출발지))
                    방문함.put(출발지, new HashMap<String, Integer>());

                for (String 도착지 : 요소.getValue().keySet()) {
                    var 맵 = 방문함.get(출발지);
                    맵.put(도착지, 요소.getValue().get(도착지));
                }
            }
        }

        boolean 방문여부(String 목적지) {
            if (!방문함.containsKey(현위치()))
                방문함.put(현위치(), new HashMap<String, Integer>());
            return 방문함.get(현위치()).get(목적지) == 간선.get(현위치()).get(목적지);
        }

        void 방문지추가(String 목적지) {
            var 현위치맵 = 방문함.get(현위치());
            현위치맵.put(목적지, 현위치맵.getOrDefault(목적지, 0) + 1);
            방문경로.add(목적지);
        }

        String 현위치() {
            return 방문경로.get(방문경로.size() - 1);
        }

        int 사용한항공권() {
            int 항공권개수 = 0;
            for (Map.Entry<String, HashMap<String, Integer>> 요소 : 방문함.entrySet()) {
                for (Map.Entry<String, Integer> 요소2 : 요소.getValue().entrySet()) {
                    항공권개수 += 요소2.getValue();
                }
            }

            return 항공권개수;
        }
    }

    public ArrayList<String> solution(String[][] tickets) {
        간선 = new HashMap<String, HashMap<String, Integer>>();
        for (String[] 티켓 : tickets) {
            String 출발지 = 티켓[0];
            String 목적지 = 티켓[1];
            if (!간선.containsKey(출발지)) 간선.put(출발지, new HashMap<String, Integer>());
            if (!간선.containsKey(목적지)) 간선.put(목적지, new HashMap<String, Integer>());
            var 출발지맵 = 간선.get(출발지);
            출발지맵.put(목적지, 출발지맵.getOrDefault(목적지, 0) + 1);
        }

        int 항공권개수 = 0;
        for (Map.Entry<String, HashMap<String, Integer>> 요소 : 간선.entrySet()) {
            for (Map.Entry<String, Integer> 요소2 : 요소.getValue().entrySet())
                항공권개수 += 요소2.getValue();
        }

        var 답 = new ArrayList<String>();
        var 큐 = new LinkedList<여행경로2>();
        큐.add(new 여행경로2("ICN"));
        while (!큐.isEmpty()) {
            여행경로2 현재경로 = 큐.remove();
            if (현재경로.사용한항공권() == 항공권개수) {
                답 = 경로비교(답, 현재경로.방문경로);
                continue;
            }

            for (String 목적지 : 간선.get(현재경로.현위치()).keySet()) {
                if (!현재경로.방문여부(목적지)) {
                    여행경로2 다음경로 = new 여행경로2(현재경로);
                    다음경로.방문지추가(목적지);
                    큐.add(new 여행경로2(다음경로));
                }
            }
        }

        return 답;
    }

    public ArrayList<String> 경로비교(ArrayList<String> 답, ArrayList<String> 현재경로) {
        if (답.isEmpty()) return 현재경로;
        for (int i = 0; i < 답.size(); i++) {
            int 비교 = 답.get(i).compareTo(현재경로.get(i));
            if (비교 < 0)
                return 답;
            else if (비교 > 0)
                return 현재경로;
        }

        return 답;
    }
}