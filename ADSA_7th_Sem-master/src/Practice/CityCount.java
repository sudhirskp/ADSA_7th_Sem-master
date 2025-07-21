package Practice;

import java.util.Arrays;

public class CityCount {

    //by using floyd warshall
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 10001);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minReach = n;
        int City = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minReach) {
                minReach = count;
                City = i;
            }
        }

        return City;
    }

    public static void main(String[] args) {

        int [][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int n = 4;
        int distanceThreshold = 4;
        CityCount ob = new CityCount();
        System.out.println(ob.findTheCity(n, edges, distanceThreshold));
    }
}

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
