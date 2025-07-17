package Practice;

import java.util.ArrayList;
import java.util.List;

public class GraphStronglyConnect {
    private boolean[] visited;

    public boolean isSC(int start, List<List<Integer>> adjList) {
        int V = adjList.size();
        visited = new boolean[V];

        dfs(start, adjList);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        List<List<Integer>> reversed = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reversed.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j : adjList.get(i)) {
                reversed.get(j).add(i);
            }
        }


        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }


        dfs(start, reversed);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int v, List<List<Integer>> adjList) {
        visited[v] = true;
        for (int i : adjList.get(v)) {
            if (!visited[i]) {
                dfs(i, adjList);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int node = 5;
        for (int i = 0; i < node; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(4).add(3);


        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("Vertex " + i + ": " + adjList.get(i));
        }

        GraphStronglyConnect g = new GraphStronglyConnect();
        System.out.println("Is strongly connected: " + g.isSC(0, adjList));
    }
}
