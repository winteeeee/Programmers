package Level3;

import java.util.*;

class 단어_변환 {
    class Node {
        String str;
        int count;

        Node(String s, int c) {
            str = s;
            count = c;
        }
    }

    public int solution(String begin, String target, String[] words) {
        var set = new HashSet<String>();
        var visited = new HashSet<String>();
        for (String w : words) {
            set.add(w);
        }

        var q = new LinkedList<Node>();
        q.add(new Node(begin, 0));
        visited.add(begin);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (cur.str.equals(target)) return cur.count;

            for (String s : set) {
                if (!visited.contains(s) && conditionOneCheck(cur.str, s)) {
                    q.add(new Node(s, cur.count + 1));
                    visited.add(s);
                }
            }
        }

        return 0;
    }

    public boolean conditionOneCheck(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (count > 1) break;
            if (a.charAt(i) != b.charAt(i)) count++;
        }

        return count == 1;
    }
}