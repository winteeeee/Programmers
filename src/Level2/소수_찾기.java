package Level2;

import java.math.*;
import java.util.*;

class 소수_찾기 {
    int answer = 0;
    String number;
    boolean[] visited;
    HashSet<Integer> determined = new HashSet<Integer>();

    public int solution(String numbers) {
        number = numbers;
        visited = new boolean[numbers.length()];

        dfs(0, "");
        return answer;
    }

    public void dfs(int length, String value) {
        if (length > number.length()) return;

        for (int i = 0; i < number.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String cur = value + String.valueOf(number.charAt(i));
                int curInt = stoi(cur);

                if (!determined.contains(curInt) && BigInteger.valueOf(curInt).isProbablePrime(10)) {
                    determined.add(curInt);
                    answer++;
                }

                dfs(length + 1, cur);
                visited[i] = false;
            }
        }
    }

    public int stoi(String n) {
        while (n.length() > 1 && n.startsWith("0")) {
            n = n.replaceFirst("0", "");
        }

        return Integer.parseInt(n);
    }
}