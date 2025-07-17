package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        int nodes = 6;
        int [][]edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 5}
        };
        Graph graph = new Graph(nodes);
        graph.edgesInGraph(edges, true);
        System.out.print("Topo Sort by using dfs: ");
        topoSort(graph, nodes);
        System.out.println();
        System.out.print("Topo Sort by using bfs- kahn's algo: ");
        topoSortByKahn(graph, nodes);

    }

    //topoSort by using dfs
    private static void topoSort(Graph graph, int nodes) {

        boolean visited[] = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfs(int node, boolean[] visited, Graph graph, Stack<Integer> stack) {
        visited[node] = true;
        for (int i = 0; i < graph.adjList.size(); i++) {
            if (!visited[i] && graph.adjMatrix[node][i] == 1) {
                dfs(i, visited, graph, stack);
            }
        }
        stack.push(node);
    }


    //topoSort by using bfs- kahn's algo

    public static void topoSortByKahn(Graph graph, int nodes) {
        int indegree[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < graph.adjMatrix[i].length; j++) {
                if (graph.adjMatrix[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int i = 0; i < nodes; i++) {
                if (graph.adjMatrix[node][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
    }

}