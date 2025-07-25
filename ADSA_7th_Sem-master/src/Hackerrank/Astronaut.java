package Hackerrank;

//Journey to the Moon - HackerRank

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DSU {
    int[] parent;
    int[] size;
    int component;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        component = n;
    }

    int find(int node) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;
        component--;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}


public class Astronaut {
    //by dfs
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> pair : astronaut) {
            int u = pair.get(0);
            int v = pair.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        List<Integer> countrySizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, visited, graph);
                countrySizes.add(size);
            }
        }

        // Compute total valid pairs
        long total = 0;
        long sum = 0;
        for (int size : countrySizes) {
            total += sum * size;
            sum += size;
        }

        return (int) total;
    }

    // DFS helper
    private static int dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, visited, graph);
            }
        }
        return count;
    }

public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(0, 4);

        // Step 1: Count frequency of each connected component (country sizes)
        Map<Integer, Integer> countrySizes = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int root = dsu.find(i);
            countrySizes.put(root, countrySizes.getOrDefault(root, 0) + 1);
        }

        // Step 2: Store all sizes in a list
        List<Integer> sizes = new ArrayList<>(countrySizes.values());

        // Step 3: Calculate total valid pairs from different countries
        long result = 0;
        long sum = 0;
        for (int size : sizes) {
            result += sum * size;
            sum += size;
        }

        System.out.println("Total valid pairs: " + result);

        //by dfs

    System.out.println("by dfs");
        int n = 5;
        List<List<Integer>> astronaut = new ArrayList<>();
        astronaut.add(new ArrayList<>(List.of(0, 1)));
        astronaut.add(new ArrayList<>(List.of(2, 3)));
        astronaut.add(new ArrayList<>(List.of(0, 4)));
        System.out.println("Total valid pairs: " + journeyToMoon(n, astronaut));

    }
}