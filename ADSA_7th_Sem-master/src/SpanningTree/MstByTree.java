package SpanningTree;

import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u; this.v = v; this.w = w;
    }
}

public class MstByTree {
    int V;
    List<List<int[]>> adj;

    MstByTree(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(Edge edge) {
        adj.get(edge.u).add(new int[]{edge.v, edge.w});
        adj.get(edge.v).add(new int[]{edge.u, edge.w});
    }

    int PrimsMst() {
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        que.offer(new int[]{0, 0});
        weight[0] = 0;
        int sum = 0;

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int u = curr[0];

            if (visited[u]) continue;
            visited[u] = true;
            sum += curr[1];

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (!visited[v] && w < weight[v]) {
                    weight[v] = w;
                    parent[v] = u;
                    que.offer(new int[]{v, w});
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MstByTree obj = new MstByTree(5);
        obj.addEdge(new Edge(0, 1, 1));
        obj.addEdge(new Edge(0, 2, 3));
        obj.addEdge(new Edge(1, 2, 5));
        obj.addEdge(new Edge(1, 3, 2));
        obj.addEdge(new Edge(2, 3, 4));

        System.out.println(obj.PrimsMst()); // Expected MST cost = 1 + 2 + 3 = 6
    }
}