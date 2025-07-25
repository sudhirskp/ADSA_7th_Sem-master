package Practice;

import java.util.List;

public class DigonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rightDiagonal =0;
        int leftDiagonal =0;
        int n = arr.get(0).size();

            for (int i = 0; i < n; i++) {
                rightDiagonal += arr.get(i).get(i);
                leftDiagonal += arr.get(i).get(n - 1 - i);
            }

        return Math.abs(leftDiagonal - rightDiagonal);
    }
    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(9, 8, 9));
        System.out.println(diagonalDifference(arr));
    }
}

//https://www.hackerrank.com/challenges/diagonal-difference/problem