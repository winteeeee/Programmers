package Level3;

import java.util.*;

class 순위 {
    final boolean DEBUG = true;
    int count;

    class Node {
        int number;
        ArrayList<Node> parents = new ArrayList<Node>();
        ArrayList<Node> children = new ArrayList<Node>();

        Node(int n) {
            number = n;
        }
    }

    public int solution(int n, int[][] results) {
        count = n;
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++)
            nodes[i] = new Node(i);

        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];

            nodes[win].children.add(nodes[lose]);
            nodes[lose].parents.add(nodes[win]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int parentCount = 0;
            int childrenCount = 0;

            var q = new LinkedList<Integer>();
            var visited = new boolean[n + 1];
            for (Node parent : nodes[i].parents) {
                parentCount++;
                q.add(parent.number);
                visited[parent.number] = true;
            }

            while (!q.isEmpty()) {
                int cur = q.remove();

                for (Node parent : nodes[cur].parents) {
                    if (!visited[parent.number]) {
                        parentCount++;
                        q.add(parent.number);
                        visited[parent.number] = true;
                    }
                }
            }

            q = new LinkedList<Integer>();
            visited = new boolean[n + 1];
            for (Node child : nodes[i].children) {
                childrenCount++;
                q.add(child.number);
                visited[child.number] = true;
            }

            while (!q.isEmpty()) {
                int cur = q.remove();

                for (Node child : nodes[cur].children) {
                    if (!visited[child.number]) {
                        childrenCount++;
                        q.add(child.number);
                        visited[child.number] = true;
                    }
                }
            }

            if (parentCount + childrenCount + 1 == n)
                answer++;
        }

        return answer;
    }
}