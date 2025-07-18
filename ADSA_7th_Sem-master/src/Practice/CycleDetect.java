package Practice;

import Graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetect {

    //cycle detect by using topoSort Kahn's Algo
    public  void isCycleByKahn(Graph graph, int nodes) {
        int indegree[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < graph.adjMatrix[i].length; j++) {
                if (graph.adjMatrix[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            count++;
            for (int i = 0; i < nodes; i++) {
                if (graph.adjMatrix[node][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        System.out.println("Elements in Topological order: " + list);
        if (count != nodes) {
            System.out.println("Graph contains cycle");
        }else {
            System.out.println("Graph doesn't contain cycle");
        }
    }

    //cycle detect by using dfs
    public void isCycleByDfsForUndirectedGraph(Graph graph, int node) {
        boolean[] visited = new boolean[node];
        for (int i = 0; i < node; i++) {
            if (visited[i] == false) {
                if (isCycle(graph, i, visited, -1)) {
                    System.out.println("Graph contains cycle");
                    return;
                }
            }
        }
        System.out.println("Graph doesn't contain cycle");
    }

    public boolean isCycle(Graph graph, int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int i = 0; i < graph.adjList.get(node).size(); i++) {
            if (!visited[graph.adjList.get(node).get(i)]) {
                if (isCycle(graph, graph.adjList.get(node).get(i), visited, node)) {
                    return true;
                }
            } else if (graph.adjList.get(node).get(i) != parent) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.MarkadjMatrix(0, 1, false);
        graph.MarkadjMatrix(1, 2, false);
        graph.MarkadjMatrix(2, 3, false);
        graph.MarkadjMatrix(3, 0, false);
        graph.MarkadjMatrix(4, 0, false);
        graph.MatrixDisplay();

        graph.adjList.get(0).add(1);
        graph.adjList.get(1).add(2);
        graph.adjList.get(2).add(3);
       graph.adjList.get(3).add(0);
       graph.adjList.get(4).add(0);

        graph.ListDisplay();


        CycleDetect c = new CycleDetect();
        //c.isCycleByKahn(graph, 5);

        c.isCycleByDfsForUndirectedGraph(graph, 5);
    }
}
