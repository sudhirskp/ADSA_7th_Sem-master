package Practice;


public class GraphConnectedOrnot {

    public boolean isConnected(int [][] Graph , int nodes){
        int count = 0;
        boolean [] visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++){
            if(!visited[i]){
                dfs(Graph,i,visited);
                count++;
            }
        }
        System.out.println(count);
        for(int i = 0; i < nodes; i++){
            if(!visited[i]){
                return true;
            }
        }
        return false;
    }

    public void dfs(int [][] Graph , int node , boolean [] visited){
        visited[node] = true;
        for(int i = 0; i < Graph[node].length; i++){
            if(!visited[Graph[node][i]]){
                dfs(Graph,Graph[node][i],visited);
            }
        }
    }

    public static void main(String[] args) {
        int [][] graph = {{0,1},{1,3},{2,3},{3,0},{5}};
        GraphConnectedOrnot g = new GraphConnectedOrnot();
        System.out.println(g.isConnected(graph,4));
    }
}
