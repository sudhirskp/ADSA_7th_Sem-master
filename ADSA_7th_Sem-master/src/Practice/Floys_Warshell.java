package Practice;

public class Floys_Warshell {

    public int [][] floys_Warshell(int n , int [][] edges) {
        int [][] dist = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                dist[i][j] = i == j ? 0 : 1000;
            }
        }
        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k = 0 ; k < n ; k++) {
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int [][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int n = 4;
        Floys_Warshell obj = new Floys_Warshell();
        int [][] dist = obj.floys_Warshell(n , edges);
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
