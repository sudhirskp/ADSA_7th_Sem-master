package Hackerrank;

import java.util.List;

public class ConnectedCellInGrid {

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int row = matrix.size();
        int col = matrix.get(0).size();
        boolean [][] visited = new boolean[row][col];
        int res =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && matrix.get(i).get(j)==1){
                    int size = dfs(i,j,visited,matrix);
                    res = Math.max(res,size);
                }
            }
        }
        return res;

    }
    public static int dfs(int r , int c, boolean [][] visited ,List<List<Integer>> matrix){
        int row = matrix.size();
        int col = matrix.get(0).size();
        visited[r][c] = true;
        int s = 1;
        int[][] dir = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        for(int [] d : dir){
            int x = d[0] + r;
            int y = d[1] + c;
            if(x < 0 || y < 0 || x >= row || y >= col || matrix.get(x).get(y)==0 || visited[x][y]){
                continue;
            }
            if(!visited[x][y] && matrix.get(x).get(y)==1){
                s +=dfs(x,y,visited,matrix);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(List.of(1, 1, 0, 0), List.of(0, 1, 1, 0), List.of(0, 0, 1, 0), List.of(1, 0, 0, 0));
        System.out.println(connectedCell(matrix));
    }

}
//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
