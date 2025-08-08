package SpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MInCostAllpoints {

    //prims algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{j,cost});
                adj.get(j).add(new int[]{i,cost});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        boolean[] visited = new boolean[n];
        int ans = 0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int cost = node[1];
            if(visited[u]) continue;
            visited[u] = true;
            ans += cost;
            for(int[] neighbor : adj.get(u)){
                if(!visited[neighbor[0]]){
                    pq.add(new int[]{neighbor[0],neighbor[1]});
                }
            }
        }
        return ans;


    }


    class DSU {
        int[] parent;
        int[] size;

        DSU(int node) {
            parent = new int[node];
            size = new int[node];

            for (int i = 0; i < node; i++) {
                parent[i] = i;
                size[i] = 1;
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

    //kruskals algorithm

        public int minCostConnectPoints1(int[][] points) {
            int n = points.length;
            int m = points[0].length;
            List<List<int[]>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }

            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                    adj.get(i).add(new int[]{j,cost});
                    adj.get(j).add(new int[]{i,cost});
                }
            }
            int ans = 0;
            DSU ds = new DSU(n);
            PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
            for(int i=0;i<n;i++){
                for(int [] node : adj.get(i)){
                    que.offer(new int[]{i,node[0],node[1]});
                }
            }

            while(!que.isEmpty()){
                int [] node = que.poll();
                int u = node[0];
                int v = node[1];
                int w = node[2];

                // int U = ds.findParent(u);
                // int V = ds.findParent(v);

                // if(U!=V){
                //      ans+=w;
                //      ds.bySize(U,V);
                // }

                if(ds.bySize(u,v)){
                    ans+=w;
                }
            }
            return ans;
        }

        //Kruskals algorithm optimized - 4x faster
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        DSU ds = new DSU(n);


        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.offer(new int[]{i, j, cost});
            }
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // Kruskal's algorithm
        while (!edges.isEmpty() && edgesUsed < n - 1) {
            int[] edge = edges.poll();
            int u = edge[0], v = edge[1], w = edge[2];

            if (ds.bySize(u, v)) {
                totalCost += w;
                edgesUsed++;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MInCostAllpoints m = new MInCostAllpoints();
        System.out.println(m.minCostConnectPoints2(points));
    }
}
