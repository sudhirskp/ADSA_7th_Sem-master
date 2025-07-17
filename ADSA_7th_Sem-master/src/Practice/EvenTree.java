package Practice;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class EvenTree {

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] ans = new int[1];

        for (int i = 0; i < t_nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < t_edges; i++) {
            adj.get(t_from.get(i) - 1).add(t_to.get(i) - 1);
            adj.get(t_to.get(i) - 1).add(t_from.get(i) - 1);
        }

        dfs(0, -1, adj, ans);

        return ans[0];
    }

    public static int dfs(int u, int parent, List<List<Integer>> adj, int[] ans) {
        int count = 1;
        for (int v : adj.get(u)) {
            if (v != parent) {
                int subCount = dfs(v, u, adj, ans);
                if (subCount % 2 == 0) {
                    ans[0]++;
                } else {
                    count += subCount;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        System.out.println(res);

        bufferedReader.close();
    }
}