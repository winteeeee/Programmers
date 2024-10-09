package Level3;

import java.util.*;

class 가장_먼_노드 {
    class Distance implements Comparable<Distance> {
        int node;
        int distance;

        public Distance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance o) {
            return Integer.compare(distance, o.distance);
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        var distances = new PriorityQueue<Distance>(Collections.reverseOrder());
        var q = new LinkedList<Integer>();
        var visited = new boolean[n + 1];
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            edges[a].add(b);
            edges[b].add(a);
        }

        q.add(1);
        q.add(0);
        visited[1] = true;
        distances.add(new Distance(1, 0));
        while (!q.isEmpty()) {
            int node = q.remove();
            int distance = q.remove();

            for (int adjustVertex : edges[node]) {
                if (!visited[adjustVertex]) {
                    q.add(adjustVertex);
                    q.add(distance + 1);
                    visited[adjustVertex] = true;
                    distances.add(new Distance(adjustVertex, distance + 1));
                }
            }
        }

        int max = distances.peek().distance;
        while (!distances.isEmpty()) {
            if (max == distances.remove().distance) answer++;
            else break;
        }


        return answer;
    }
}