package Practice;

import java.util.*;

class Pair{
    int v;
    int wt;
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
public class Dijikastra {

    public static int [] dijkstra(int[][] graph, int start) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));

        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] node : graph) {
            int u = node[0];
            int v = node[1];
            int wt = node[2];
            Pair p1 = new Pair(v, wt);
            Pair p2 = new Pair(u, wt);

            adjList.get(u).add(p1);
            adjList.get(v).add(p2);

        }

        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int d = top[1];

            if (d > dist[u]) {
                continue;
            }

            for (Pair p : adjList.get(u)) {
                int v = p.v;
                int wt = p.wt;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
    public static void main (String[] args){
        int[][] graph = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 1, 1}, {1, 4, 6}, {4, 5, 7}};
        int start = 0;
        int [] dist = dijkstra(graph, start);
        for (int i = 0; i < dist.length; i++) {
            System.out.print("Distance from " + start + " to " + i + " is " + dist[i] + "\n");
        }
    }
}
