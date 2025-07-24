package Practice;

import java.util.Arrays;

public class Bellmen_ford {

    public int []bellmanFord(int n , int [][] edges, int src){
        int [] dist = new int[n];
        Arrays.fill(dist , 10000);
        dist[src] = 0;
        for(int i = 0 ; i < n-1 ; i++){
            for(int [] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u] != 10000 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        //for negative cycle
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u] != 10000 && dist[u] + w < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 3;
        int [][] edges = {{0,1,9}};
        int src = 0;
        Bellmen_ford obj = new Bellmen_ford();
        int [] dist = obj.bellmanFord(n , edges, src);
        for(int i = 0 ; i < n ; i++){
            System.out.print(dist[i] + " ");
        }
    }
}
