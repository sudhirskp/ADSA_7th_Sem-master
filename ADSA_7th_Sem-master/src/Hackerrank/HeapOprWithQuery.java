package Hackerrank;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapOprWithQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>(); // tracks actual elements

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                minHeap.add(x);
                set.add(x);
            } else if (type == 2) {
                int x = sc.nextInt();
                set.remove(x); // mark x as deleted logically
            } else if (type == 3) {
                while (!set.contains(minHeap.peek())) {
                    minHeap.poll(); // remove logically deleted elements
                }
                System.out.println(minHeap.peek());
            }
        }
    }
}
//hackerrank problem