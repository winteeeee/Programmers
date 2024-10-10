package Level1;

import java.util.HashMap;
import java.util.Map;

class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            if (map.get(completion[i]) == 0) map.remove(completion[i]);
        }

        String answer = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            answer = e.getKey();
        }

        return answer;
    }
}