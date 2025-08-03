package Hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int n = a.size();
        List<Double> res = new ArrayList<>();
        PriorityQueue<Integer> que1 = new PriorityQueue<>();
        PriorityQueue<Integer> que2 = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            que1.offer(a.get(i));
            que2.offer(que1.poll());

            if (que1.size()<que2.size()){
                que1.offer(que2.poll());
            }

            if(que1.size()==que2.size()){
                int v1 = que1.peek();
                int v2 = que2.peek();
                res.add(((v1+v2)/2.0));
            }else{
                res.add((double)que1.peek());
            }
        }

        return res;

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(3);
        arr.add(5);
        arr.add(2);
        List<Double> res = runningMedian(arr);
        System.out.println(res);
    }
}
//https://www.hackerrank.com/challenges/find-the-running-median/problem