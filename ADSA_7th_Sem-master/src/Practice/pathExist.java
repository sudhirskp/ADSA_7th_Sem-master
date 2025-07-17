package Practice;

import java.util.*;

public class pathExist {

    public boolean isPathDirected(int V, List<List<Integer>> adj, int source, int dest) {
        boolean[] visited = new boolean[V];
        dfs(source, adj, visited);
        return visited[dest];
    }

    private void dfs(int v, List<List<Integer>> adj, boolean[] visited) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                dfs(i, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        pathExist p = new pathExist();
        System.out.println(p.isPathDirected(V, adj, 0, 3));
    }

}