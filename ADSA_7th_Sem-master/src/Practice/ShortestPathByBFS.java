package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathByBFS {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {

        int n = adj.size();
        int [] distance = new int[n];
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(distance, -1);
        que.offer(src);
        distance[src] = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            for (int neigh : adj.get(node)) {
                if (distance[neigh] == -1) {
                    distance[neigh] = distance[node] + 1;
                    que.offer(neigh);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 4;
        int src = 0;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(3);
        ShortestPathByBFS ob = new ShortestPathByBFS();
        System.out.print("Shortest Path  Array: ");
        System.out.println(Arrays.toString(ob.shortestPath(adj, 0)));
        int[] distances = ob.shortestPath(adj, src);
        for (int i = 0; i < n; i++)
            System.out.println("Shortest Path of " + src + " to " + i + " is " + distances[i]);
    }
}
