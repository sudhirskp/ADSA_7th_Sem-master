package Hackerrank;

import java.util.*;

public class MinDistanceByBFS {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[s] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        int w = 6;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + w;
                    queue.offer(neighbor);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                ans.add(dist[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(3, 4));
        int s = 1;
        List<Integer> result = bfs(n, m, edges, s);
        System.out.println(result);
    }
}
//Breadth First Search: Shortest Reach