package Practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    int kthLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
            System.out.println(pq);
        }
        if(pq.size() == k){
            return pq.peek();
        }
        return 0;
    }


    int kthSmallest(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < n ; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
            System.out.println(pq);
        }
        if(pq.size() == k){
            return pq.peek();
        }
        return 0;
    }
    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        KthLargest obj = new KthLargest();
        System.out.println("Kth Largest : ");
        System.out.println(obj.kthLargest(arr, arr.length, 2));
        System.out.println("Kth Smallest : ");
        System.out.println(obj.kthSmallest(arr, arr.length, 2));
    }
}
//leetCode 215