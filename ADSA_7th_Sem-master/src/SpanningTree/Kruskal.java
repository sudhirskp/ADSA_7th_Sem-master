package SpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class DSU {
    int[] parent;
    int[] size;

    DSU(int node) {
        parent = new int[node];
        size = new int[node];

        for (int i = 0; i < node; i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }

    int findParent(int node) {
        if (parent[node]==node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    //union by size

    boolean bySize(int u, int v) {
        int U = findParent(u);
        int V = findParent(v);

        if (U == V) {
            return false;
        }

        if (size[U] > size[V]) {
            size[U] += size[V];
            parent[V] = U;
        } else {
            size[V] += size[U];
            parent[U] = V;
        }
        return true;
    }

}

public class Kruskal{

    public int ImplementMSTByKruskal(List<List<int[]>> adj) {
        int ans = 0;
        DSU dsu = new DSU(adj.size());
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));

        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                pq.add(new ArrayList<>(List.of(adj.get(i).get(j)[1], i, adj.get(i).get(j)[0])));
            }
        }

        while (!pq.isEmpty()) {
            List<Integer> node = pq.poll();

            if (dsu.bySize(node.get(1), node.get(2))) {
                ans += node.get(0);
            }
        }

        return ans;
    }

    //implementation of kruskal by disjoint set and priority queue
    public static void main(String[] args) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = 5;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new int[]{1, 1});
        adj.get(0).add(new int[]{2, 3});
        adj.get(1).add(new int[]{2, 5});
        adj.get(1).add(new int[]{3, 2});
        adj.get(2).add(new int[]{3, 4});
        Kruskal kruskal = new Kruskal();
        int ans = kruskal.ImplementMSTByKruskal(adj);
        System.out.println(ans);

    }
}
