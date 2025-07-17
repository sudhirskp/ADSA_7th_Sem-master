package Practice;

import java.util.*;

public class SourceTodestination {

    public boolean isReachable(int V, List<List<Integer>> adj, int source, int dest) {
        boolean[] visited = new boolean[V];
        dfs(source, adj, visited);
        return visited[dest];
    }

    private void dfs(int v, List<List<Integer>> adj, boolean[] visited) {
        visited[v] = true;
        for (int x : adj.get(v)) {
            if (!visited[x]) {
                dfs(x, adj, visited);
            }
        }

    }

    public static void main(String[] args) {
        SourceTodestination s = new SourceTodestination();
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(2).add(1);
        adj.get(3).add(2);
        int source = 0;
        int dest = 3;
        System.out.println(s.isReachable(V, adj, source, dest));
    }
}