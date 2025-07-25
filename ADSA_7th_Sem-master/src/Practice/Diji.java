package Practice;


import java.util.*;

public class Diji {
    class pair{
        int v;
        int w;
        pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

//    int [][] AddWeightEdge(int n ,int u , int v , int w){
//        int [][] edge = new int[n][n];
//        edge[u][v] = w;
//        edge[v][u] = w;
//        return edge;
//    }

    List<List<pair>> makeAdjList(int n , int [][] edges , boolean isdirected){
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(isdirected){
                adj.get(u).add(new pair(v,w));
            }else{
                adj.get(u).add(new pair(v,w));
                adj.get(v).add(new pair(u,w));
            }
        }
        return adj;
    }

    int [] dijkstra(int src , List<List<pair>> adj , int n){
        int [] dis = new int [n];
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        Arrays.fill(dis,10000);
        dis[src] = 0;
        que.offer(new int []{src,0});

        while(!que.isEmpty()) {
            int [] Node = que.poll();
            int u = Node[0];
            int d = Node[1];
            if(d > dis[u]) continue;
            for (pair node : adj.get(u)) {
                int v = node.v;
                int w = node.w;
                if (dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    que.offer(new int []{v,dis[v]});
                }
            }
        }
        return dis;
    }

    void Test1(int src,int n, int [][] edge , boolean isdirected){
        System.out.println("Test Case 1st : " +  src + " to Each-Node" );
        int [] res = dijkstra(src,makeAdjList(n,edge,isdirected),n);
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + res[i]);
        }
    }

    void Test2(){
        int src = 0;
        int [][] edge = {{0,1,3},{1,5,2},{0,3,4},{3,2,3},{3,1,0},{2,5,2}};
        int n = edge.length;
        boolean isdirected = true;
        System.out.println("Test Case 2nd : " +  src + " to Each-Node" );
        int [] res = dijkstra(src,makeAdjList(n,edge,isdirected),n);
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + res[i]);
        }
    }

    void Test3(){
        int src = 0;
        int [][] edge = {{0,1,5},{1,2,3},{2,3,2},{3,4,1},{0,4,3}};
        int n = edge.length;
        boolean isdirected = true;
        System.out.println("Test Case 3rd : " +  src + " to Each-Node" );
        int [] res = dijkstra(src,makeAdjList(n,edge,isdirected),n);
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + res[i]);
        }
    }

    void Test4(){
        int src = 0;
        int [][] edge = {{0,1,1},{0,2,5},{1,3,2},{2,3,1},{2,4,6},{3,5,3},{4,5,1}};
        int n = edge.length;
        boolean isdirected = true;
        System.out.println("Test Case 4th : " +  src + " to Each-Node" );
        int [] res = dijkstra(src,makeAdjList(n,edge,isdirected),n);
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + res[i]);
        }
    }

    void Test5(){
        int src = 0;
        int [][] edge = {{0,1,3},{0,2,6},{0,3,1},{1,2,4},{1,4,2},{2,3,5},{2,5,7},{3,4,1},{3,5,3},{4,5,2}};
        int n = edge.length;
        boolean isdirected = true;
        System.out.println("Test Case 5th : " +  src + " to Each-Node" );
        int [] res = dijkstra(src,makeAdjList(n,edge,isdirected),n);
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + res[i]);
        }
    }


    public static void main(String[] args) {
        Diji ob = new Diji();
        int [][] edge = {{0,1,1},{1,5,3},{0,3,1},{3,2,5},{3,1,2},{2,5,4}};
        ob.Test1(0,6,edge,true);

        System.out.println("This is Test 2");
        ob.Test2();

        System.out.println("This is Test 3");
        ob.Test3();

        System.out.println("This is Test 4");
        ob.Test4();

        System.out.println("This is Test 5");
        ob.Test5();

    }
}
