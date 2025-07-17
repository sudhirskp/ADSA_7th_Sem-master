package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    List<List<Integer>> adjList;
    int [][] adjMatrix;
    List<List<Integer>> edges = new ArrayList<>();

    public Graph(int node){
        adjList = new ArrayList<>();
        adjMatrix = new int[node+1][node+1];
        for (int i = 0; i < node; i++) {
            adjList.add(new ArrayList<>());
        }
    }


    public void MarkadjMatrix(int u, int v , boolean isdirected){
        if(isdirected){
            adjMatrix[u][v] = 1;
            return;
        }
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }



    public void addEdgeList(int u, int v, boolean isdirected){
        if(isdirected){
            adjList.get(u).add(v);
        }else{
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void edgeList(int u, int v){
        List<Integer> edge = new ArrayList<>();
        edge.add(u);
        edge.add(v);
        edges.add(edge);
    }

    public void deleteEdgeList(int u, int v, boolean isdirected){
        if(isdirected){
            adjList.get(u).remove(Integer.valueOf(v));
        }else{
            adjList.get(u).remove(Integer.valueOf(v));
            adjList.get(v).remove(Integer.valueOf(u));
        }
    }

    public void edgesInGraph(int [][]edges , boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                adjMatrix[u][v] = 1;
            }else{
                adjMatrix[u][v] =1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    //dfs trvarsal by using adjList
    public void dfsTraversal(int node){
        boolean [] visited = new boolean[adjList.size()];
        //boolean [] visited = new boolean[4];
        dfs(node,visited);
    }

    public void dfs(int node, boolean [] visited){
        visited[node] = true;
        System.out.print(node + " ");
        for(int node1 : adjList.get(node)){
            if(node1 < visited.length && !visited[node1]){
                dfs(node1,visited);
            }
        }
    }

    //dfs traversal by using adjMatrix
    public void dfsMatrix(int node) {
        boolean[] visited = new boolean[adjMatrix.length];
        dfsMT(node, visited);
    }

    public void dfsMT(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < adjMatrix[node].length; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsMT(i, visited);
            }
        }
    }

    //bfs using the adjList
    public void bfs(int node){
        boolean [] visited = new boolean[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int node1 : adjList.get(temp)){
                if(!visited[node1]){
                    q.offer(node1);
                }
            }
        }
    }

    //bfs using the adjMatrix
    public void bfsMatrix(int node){
        boolean [] visited = new boolean[adjMatrix.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int i = 0; i < adjMatrix[temp].length; i++){
                if(adjMatrix[temp][i] == 1 && !visited[i]){
                    q.offer(i);
                }
            }
        }
    }


    void edgeDisplay(){
//        for(int i = 0; i < edges.size(); i++){
//            System.out.println(edges.get(i).get(0) + " -> " + edges.get(i).get(1));
//        }
//        System.out.println();
        System.out.println(edges);
    }
    void ListDisplay() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void MatrixDisplay() {
        for(int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
            Graph ob = new Graph(4);
            ob.addEdgeList(0, 1, true);
            ob.addEdgeList(0, 2, true);
            ob.addEdgeList(1, 3, true);
            ob.addEdgeList(2, 4, true);

            ob.ListDisplay();

            ob.MarkadjMatrix(0, 1, true);
            ob.MarkadjMatrix(0, 2, true);
            ob.MarkadjMatrix(1, 3, true);
            ob.MarkadjMatrix(2, 4, true);
            ob.MatrixDisplay();

            ob.edgeList(0, 1);
            ob.edgeList(0, 2);
            ob.edgeList(1, 3);
            ob.edgeList(2, 4);
            ob.edgeDisplay();

            ob.dfsTraversal(0);
            System.out.println();

            ob.dfsMatrix(0);

        System.out.println();

            ob.bfs(0);

    }
}
