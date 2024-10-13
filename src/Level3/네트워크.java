package Level3;

class 네트워크 {
    int[][] edges;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        edges = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    public void dfs(int vertex) {
        visited[vertex] = true;
        for (int i = 0; i < edges[vertex].length; i++) {
            int e = edges[vertex][i];
            if (e == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}