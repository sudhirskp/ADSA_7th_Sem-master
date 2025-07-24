package Practice;

import java.util.*;

public class CityCountBydiji {
    class Pair {
        int v, w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int minReachable = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0], dist = node[1];

                if (dist > dis[u]) continue;

                for (Pair nei : adj.get(u)) {
                    int v = nei.v, w = nei.w;
                    if (dis[u] + w < dis[v]) {
                        dis[v] = dis[u] + w;
                        pq.offer(new int[]{v, dis[v]});
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dis[j] <= distanceThreshold) {
                    count++;
                }
            }

            // If tie, prefer higher index
            if (count <= minReachable) {
                minReachable = count;
                resultCity = i;
            }
        }

        return resultCity;
    }

    public static void main(String[] args) {
        int n = 4;
        int [][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        CityCountBydiji ob = new CityCountBydiji();
        System.out.println(ob.findTheCity(n, edges, distanceThreshold));
    }
}