package Level2;

import java.util.*;

class 프로세스 {
    class Process {
        int priority;
        int idx;

        Process(int p, int i) {
            priority = p;
            idx = i;
        }
    }

    public int solution(int[] priorities, int location) {
        var q = new LinkedList<Process>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(priorities[i], i));
        }

        int count = 1;
        while (!q.isEmpty()) {
            Process cur = q.removeFirst();

            boolean executable = true;
            for (Process p : q) {
                if (p.priority > cur.priority) {
                    executable = false;
                    break;
                }
            }

            if (executable) {
                if (cur.idx == location) return count;
                count++;
            } else {
                q.addLast(cur);
            }
        }

        return count;
    }
}